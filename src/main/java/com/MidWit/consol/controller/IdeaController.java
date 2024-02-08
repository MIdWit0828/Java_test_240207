package com.MidWit.consol.controller;

import com.MidWit.consol.common.IdeaCondition;
import com.MidWit.consol.model.dto.IdeaDTO;
import com.MidWit.consol.model.service.IdeaService;
import com.MidWit.consol.view.MenuPrint;

import java.util.List;

public class IdeaController {
    public IdeaService ideaService = new IdeaService();
    public MenuPrint menuPrint = new MenuPrint();
    public void selectAllIdea() {
        List<IdeaDTO> ideaList = ideaService.selectAllIdea();

        if (ideaList != null && !ideaList.isEmpty()) {
            menuPrint.printSuccessMsg("selectAllIdea",0);
            menuPrint.printIdeas(ideaList);
        } else {
            menuPrint.printErrorMsg("selectAllIdea");
        }
    }

    public void selectIdeaByCondition(IdeaCondition ideaCondition) {

        List<IdeaDTO> ideaList = ideaService.selectIdeaByCondition(ideaCondition);

        if (ideaList != null && !ideaList.isEmpty()) {
            menuPrint.printSuccessMsg("byCondition",0);
            menuPrint.printIdeas(ideaList);
        } else {
            menuPrint.printErrorMsg("byCondition");
        }
    }

    public void insertIdea(IdeaDTO idea) {
        boolean isSuccess = ideaService.insertNewIdea(idea);

        if (isSuccess) {
            menuPrint.printSuccessMsg("insertIdea",0);
        } else {
            menuPrint.printErrorMsg("insertIdea");
        }
    }

    public void updateIdea(IdeaDTO idea) {
        boolean isSuccess = ideaService.updateIdea(idea);

        if (isSuccess) {
            menuPrint.printSuccessMsg("updateIdea",0);
        } else {
            menuPrint.printErrorMsg("updateIdea");
        }
    }

    public void deleteIdea(IdeaCondition ideaCondition) {
        int result = ideaService.deleteIdea(ideaCondition);

        if (result > 0) {
            menuPrint.printSuccessMsg("deleteIdea", result);
        } else {
            menuPrint.printErrorMsg("deleteIdea");
        }
    }
}
