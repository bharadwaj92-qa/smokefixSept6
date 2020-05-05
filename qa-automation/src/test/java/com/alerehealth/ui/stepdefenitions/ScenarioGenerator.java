package com.alerehealth.ui.stepdefenitions;

import com.alerehealth.fwk.excel.ExcelReader;

import java.io.*;

public class ScenarioGenerator {

    private static int scenariosCount = 0;

    public static void main(String[] args) throws IOException {

        ExcelReader excelReader = new ExcelReader("WBAMasterSheet.xlsx", "driver");

        FileWriter fileWriter = new FileWriter(".\\src\\test\\resources\\ui\\features\\generatedscenarios.feature");

        excelReader.setStartRow(1);

        fileWriter.write("Feature: WBA scenarios generated from Driver sheet \n");

        for(int i=1;i<excelReader.getRowCount(); i++){

            String scenarioContent =
                    "@UI @UIRegression @WBAGeneratedScenarios \n"+
                            "Scenario: <Description>\n" +
                            "    Given Create user based on data provided in excelsheet\n" +
                            "      | sheetname | <sheetname>|\n" +
                            "    When Answer WBA Questionnaire as per Sheet\n" +
                            "    Then i validate the reportSummary\n";

            String executionStatus = excelReader.getCellValue("Run",i).trim().toLowerCase();

            if(executionStatus.equals("y")||executionStatus.equals("yes")){

                String scenarioDescription = excelReader.getCellValue("Description",i);
                if(scenarioDescription==null||scenarioDescription.isEmpty()){

                    scenarioDescription = excelReader.getCellValue("Scenario Name",i);
                }

                scenarioContent =scenarioContent.replace("<Description>", scenarioDescription);

                String sheetName = excelReader.getCellValue("Worksheet Name",i);

                if(sheetName!=null && !sheetName.isEmpty()) {
                    scenarioContent= scenarioContent.replace("<sheetname>", sheetName);
                    
                    System.out.println("Adding scenario "+excelReader.getCellValue("Scenario Name",i)+" to feature file");

                    fileWriter.write(scenarioContent);

                    fileWriter.flush();

                    scenariosCount++;
                }else{
                	
                System.out.println("Ignoring scenario "+excelReader.getCellValue("Scenario Name",i)+" as sheetname is not found");

                }

                

            }



        }

        fileWriter.close();




    }


    

}
