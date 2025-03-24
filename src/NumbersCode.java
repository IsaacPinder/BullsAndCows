import java.util.*  ;

public class NumbersCode extends SecretCode {
        public NumbersCode() {
                decipheredCode = codeGenerator();
        }
        private String codeGenerator() {
                // this is responsible in creating the 4digit code and the numbers are between 0-9
                List<Integer> num = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                        num.add(i);
                }
                // this is used to randomly reorder the elements in the list
                Collections.shuffle(num);

                // this process builds the 4-digit code sequentially without the overhead of creating a new string at every step.
                StringBuilder code = new StringBuilder();
                for (int i = 0; i < 8; i++) {
                        code.append(num.get(i));
                }
                return code.toString();
        }
}


