package com.MidWit.consol.view;

import com.MidWit.consol.common.IdeaCondition;
import com.MidWit.consol.controller.IdeaController;
import com.MidWit.consol.model.dto.IdeaDTO;

import java.util.Scanner;

public class MainMenu {
    public MainMenu() {
        Scanner sc = new Scanner(System.in);
        IdeaController ideaController = new IdeaController();
        do {
            System.out.println("=========================");
            System.out.println("|       메인 메뉴         |");
            System.out.println("=========================");
            System.out.println("1. 아이디어 전체 조회");
            System.out.println("2. 검색 매뉴");
            System.out.println("3. 아이디어 추가");
            System.out.println("4. 아이디어 수정");
            System.out.println("5. 아이디어 삭제");
            System.out.println("9. 프로그램 종료");
            System.out.println("=========================");
            System.out.print("코드 입력 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 -> ideaController.selectAllIdea();
                case 2 -> ideaController.selectIdeaByCondition(inputIdeaCondition());
                case 3 -> ideaController.insertIdea(inputNewIdea());
                case 4 -> ideaController.updateIdea(inputUpdateIdea());
                case 5 -> ideaController.deleteIdea(inputDeleteIdea());
                case 9 -> System.exit(0);
            }
        } while (true);
    }

    private IdeaCondition inputIdeaCondition() {
        Scanner sc = new Scanner(System.in);
        String option = "";
        String value = "";

        System.out.println("=========================");
        System.out.println("|       검색 메뉴         |");
        System.out.println("=========================");
        System.out.println("1. 코드 검색");
        System.out.println("2. 이름 검색");
        System.out.println("3. 타입 검색");
        System.out.println("4. 난이도 검색");
        System.out.println("=========================");
        System.out.print("코드 입력 : ");
        int no = sc.nextInt();
        sc.nextLine();
        switch (no) {
            case 1 -> {
                option = "SearchCode";
                System.out.print("검색하고 싶은 코드를 입력하세요 : ");
                value = sc.nextLine();
            }
            case 2 -> {
                option = "SearchName";
                System.out.print("아이디어 이름 입력 : ");
                value = sc.nextLine();
            }
            case 3 -> {
                option = "SearchType";
                System.out.println("( 색, 동세, 캐릭터, 복장, 배경, 컨셉 )");
                System.out.print("타입 이름 입력 : ");
                value = sc.nextLine();
            }
            case 4 -> {
                option = "SearchRank";
                System.out.print("난이도 입력(정수) : ");
                value = sc.nextLine();
            }
        }

        IdeaCondition condition = new IdeaCondition(option, value);

        return condition;
    }

    private IdeaDTO inputNewIdea() {

        System.out.println("=========================");
        System.out.println("|   새로운 아이디어 추가    |");
        System.out.println("=========================");

        IdeaDTO newIdea = getIdeaInfo();

        return newIdea;
    }

    private IdeaDTO inputUpdateIdea() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=========================");
        System.out.println("|      아이디어 수정       |");
        System.out.println("=========================");
        System.out.print("수정할 아이디어의 코드 입력 : ");
        int code = sc.nextInt();
        sc.nextLine();
        IdeaDTO updateIdea = getIdeaInfo();
        System.out.print("수행횟수를 초기화 하시겠습니까? (예/아니오) : ");
        String str = sc.nextLine();

        if (str.equals("아니오")) {
            updateIdea.setWorkCount(-1);
        }
        updateIdea.setIdeaCode(code);
        return updateIdea;
    }

    public IdeaDTO getIdeaInfo() {

        Scanner sc = new Scanner(System.in);

        System.out.print("아이디어 이름 :");
        String name = sc.nextLine();
        System.out.print("아이디어 난이도 :");
        int rank = sc.nextInt();
        sc.nextLine();
        System.out.println("( 색, 동세, 캐릭터, 복장, 배경, 컨셉 )");
        System.out.print("아이디어 타입 :");
        String type = sc.nextLine();

        IdeaDTO newIdea = new IdeaDTO(name,rank,type);

        return newIdea;
    }

    private IdeaCondition inputDeleteIdea() {
        Scanner sc = new Scanner(System.in);
        String condition = "";
        String value = "";

        System.out.println("=========================");
        System.out.println("|      아이디어 삭제       |");
        System.out.println("=========================");
        System.out.println("1. 코드를 기준으로 삭제");
        System.out.println("2. 이름을 기준으로 삭제");
        System.out.println("3. 작업횟수를 기준으로 삭제");
        System.out.print("기준 입력 : ");
        int no = sc.nextInt();
        sc.nextLine();

        switch (no) {
            case 1 -> {
                condition = "deleteByCode";
                System.out.println("<<<코드를 기준으로 삭제>>>");
                System.out.print("삭제할 코드 입력 : ");
                value = sc.nextLine();
            }
            case 2 -> {
                condition = "deleteByName";
                System.out.println("<<<이름을 기준으로 삭제>>>");
                System.out.print("삭제할 이름 입력 : ");
                value = sc.nextLine();
            }
            case 3 -> {
                condition = "deleteByWorkCount";
                System.out.println("<<<작업횟수를 기준으로 삭제>>>");
                System.out.print("n번 이상 작업한 아이디어 삭제 : ");
                value = sc.nextLine();
            }
        }

        return new IdeaCondition(condition, value);
    }
}
