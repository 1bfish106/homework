package Project;

import java.util.Scanner;

public class AnimalMenu {

   AnimalManager animalManager = new AnimalManager();

   Scanner sc = new Scanner(System.in);


   public void mainMenu(){

       while(true){
           System.out.println("============메뉴선택");
           System.out.println("1. 동물 추가");
           System.out.println("2. 동물 전체 조회");
           System.out.println("3. 정렬하여 조회");
           System.out.println("4. 동물명으로 검색");
           System.out.println("5. 종으로 검색");
           System.out.println("6. 동물 정보 수정");
           System.out.println("7. 동물 삭제");
           System.out.println("0. 프로그램 종료");


           System.out.println("메뉴선택 : ");
           int menu = sc.nextInt();
           sc.nextLine();

           switch (menu){
               case 1:
                   addList();
                   break;
               case 2:
                   selectList();
                   break;
               case 3:
                   sortMenu();
                   break;
               case 4:
                   searchArtist();
                   break;
               case 5:
                   searchTitle();
                   break;
               case 6:
                   updateMusic();
                   break;
               case 7:
                   removeMusic();
                   break;
               case 0:
                   System.out.println("프로그램을 종료합니다.");
                   break mainMenu;
               default:
                   System.out.println("잘못 선택하셨습니다. 번호를 다시 입력해주세요.");
                   break;
           }

       }

   }
    public void addList() {
        System.out.println("===== 동물 추가 =====");
        System.out.print("동물 이름 입력 : ");
        String animal = sc.nextLine();
        System.out.print("종 입력 : ");
        String name = sc.nextLine();

       AnimalManager.addList(new AniamlDTO(animal, name));
    }

}
