package Project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
                   searchname();
                   break;
               case 5:
                   searchSpecies();
                   break;
               case 6:
                   updatespecies();
                   break;
               case 7:
                   removeAnimal();
                   break;
               case 0:
                   System.out.println("프로그램을 종료합니다.");
                   return;
               default:
                   System.out.println("잘못 선택하셨습니다. 번호를 다시 입력해주세요.");
                   break;
           }

       }

   }
    public void addList() {
        System.out.println("===== 동물 추가 =====");
        System.out.print("동물 이름 입력 : ");
        String name = sc.nextLine();
        System.out.print("종 입력 : ");
        String species = sc.nextLine();

      animalManager.addList(new AnimalDTO(name, species));
    }
    public void selectList(){
        System.out.println("=====동물을 전체 조회합니다=====");
        List<AnimalDTO> animalList = animalManager.selectAnimal();
        if(!animalList.isEmpty()){
            for (AnimalDTO name : animalList){
                System.out.println(name);
            }
        }else {
            System.out.println("목록이 존재하지 않습니다.");
        }
    }

    public void sortMenu() {
        System.out.println("===== 정렬 메뉴 =====");
        System.out.println("1. 동물명 오름차순 정렬");
        System.out.println("2. 종 오름차순 정렬");
        System.out.println("3. 동물명 내림차순 정렬");
        System.out.println("4. 종 내림차순 정렬");
        System.out.print("메뉴 선택 : ");
        int menu = sc.nextInt();

        Descname(menu);
    }

    public void Descname(int menu){
        System.out.println("=====정렬하여 조회=====");
        List<AnimalDTO> animalList = animalManager.selectAnimal();

        if (animalList.isEmpty()){
            System.out.println("목록이 존재하지않습니다.");
            return;
        }
        List<AnimalDTO> sortList = new ArrayList<>();
        sortList.addAll(animalList);

        if(menu == 1)
            sortList.sort(new Comparator<AnimalDTO>() {
                @Override
                public int compare(AnimalDTO o1, AnimalDTO o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });else if (menu == 2){
                sortList.sort(new AscSpecies());
        }else if (menu == 3){
                sortList.sort(new Descname());
        }else {
                sortList.sort(new Descspecies());
        }
        for (int i = 0; i < sortList.size(); i++){
            System.out.println(sortList.get(i));
        }
    }

    public void searchname(){
        System.out.println("====동물명으로 검색====");
        System.out.println("동물명 입력 : ");
        List<AnimalDTO> searchList = animalManager.searchname(sc.nextLine());

        if(!searchList.isEmpty()){
            for(int i = 0; i < searchList.size(); i++){
                System.out.println(searchList.get(i));
            }
        }else{
            System.out.println("검색결과가 없습니다.");
        }

    }

    public void searchSpecies(){
        System.out.println("====종으로 검색====");
        System.out.println("종을 입력하세요 : ");
        List<AnimalDTO> searchList = animalManager.searchSpecies(sc.nextLine().trim().toLowerCase());

        if(!searchList.isEmpty()){
            for (AnimalDTO animalDTO : searchList) {
                System.out.println(animalDTO);
            }
        }else{
            System.out.println("검색결과가 없습니다.");
        }

    }
    public void updatespecies(){
        System.out.println("====동물 정보 수정====");
        System.out.println("수정할 동물의 id를 입력하세요 : ");
        int id = sc.nextInt();

        // 그냥 하면 넘어가지질않아서
        // 입력 버퍼에 남아 있는 새 줄 문자 소비
        sc.nextLine();

        String currentName = animalManager.getAnimalNameById(id);
        if (currentName != null) {
            System.out.println("현재 동물 명: " + currentName);
        }
        System.out.println("수정할 동물 명 : ");
        String updatename = sc.nextLine();
        sc.nextLine();

        String currentSpecies = animalManager.getAnimalSpeciesById(id);
        if (currentName != null) {
            System.out.println("현재 동물 종: " + currentSpecies);
        }

        System.out.println("수정할 종 : ");
        String updatespecies = sc.nextLine();

        AnimalDTO updateAnimal = new AnimalDTO(id, updatename, updatespecies);

        if(animalManager.updateAnimal(updateAnimal)) {
            System.out.println("성공적으로 수정했습니다.");
        }else{
            System.out.println("수정할 동물을 찾지못했습니다");
        }
    }

    public void removeAnimal(){
        System.out.println("====동물 삭제====");
        System.out.println("삭제할 동물의 id : ");
        if(animalManager.removeAnimal(sc.nextInt())){
            System.out.println("성공적으로 삭제되었습니다");
        }else {
            System.out.println("삭제할 동물을 찾지못했습니다.");
        }
        sc.nextLine();
    }
}
