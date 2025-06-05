package ex_02_ra_Concepts;

public class APITesting_Lab03 {

        // NoDesignPattern

        public void step1(){
            System.out.println("Step 1");
        }

        public void step2(){
            System.out.println("Step 2");
        }

        public void step3(String param1){
            System.out.println("Step 3");
        }

        public static void main(String[] args) {
            APITesting_Lab03 np = new APITesting_Lab03();
            np.step1();
            np.step2();
            np.step3("Abhishek");
        }


}
