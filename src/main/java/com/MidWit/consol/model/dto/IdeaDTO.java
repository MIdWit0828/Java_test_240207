package com.MidWit.consol.model.dto;

public class IdeaDTO {
    private int ideaCode;
    private String ideaName;
    private int ideaRank;
    private int workCount;
    private int typeCode;
    private String workStatus;

    public IdeaDTO() {

        workCount = 0;
        workStatus = "N";
    }

    public IdeaDTO(String name, int rank, String typeName) {
        this.ideaName = name;
        this.ideaRank = rank;
        this.typeCode = getTypeCode(typeName);
        workCount = 0;
        workStatus = "N";
    }

    @Override
    public String toString() {

        return "(" + ideaCode + ") " + getTypeName(typeCode) + " " + ideaName + " " + makeRankNumToStar(ideaRank);
    }

    private String getTypeName(int typeCode) {
        String typeName = "";
        switch (typeCode) {
            case 1 -> typeName = "Color";
            case 2 -> typeName = "Movement";
            case 3 -> typeName = "Character";
            case 4 -> typeName = "Costume";
            case 5 -> typeName = "Background";
            case 6 -> typeName = "Concept";
        }
        return "[" + typeName + "]";
    }

    private String makeRankNumToStar(int ideaRank) {
        String star = "";
        for (int i = 0; i < ideaRank; i++) {
            star += "★";
        }
        return star;
    }

    public int getIdeaCode() {
        return ideaCode;
    }

    public String getIdeaName() {
        return ideaName;
    }

    public int getIdeaRank() {
        return ideaRank;
    }

    public int getWorkCount() {
        return workCount;
    }

    public int getTypeCode() {
        return typeCode;
    }
    private int getTypeCode(String typeName) {
        int temp = 1;
        switch (typeName) {
            case "색" -> temp =1;
            case "동세" -> temp = 2;
            case "캐릭터" -> temp = 3;
            case "복장" -> temp = 4;
            case "배경" -> temp = 5;
            case "컨셉" -> temp = 6;
        }
        return temp;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setIdeaCode(int ideaCode) {
        this.ideaCode = ideaCode;
    }

    public void setIdeaName(String ideaName) {
        this.ideaName = ideaName;
    }

    public void setIdeaRank(int ideaRank) {
        this.ideaRank = ideaRank;
    }

    public void setWorkCount(int workCount) {
        this.workCount = workCount;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }
}
