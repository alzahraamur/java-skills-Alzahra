public class GradeManager {


        public static String[] reverseStudentNames(String[] names) {
            String[] reversedNames = new String[names.length];
            for (int i = 0; i < names.length; i++) {
                String name = names[i];
                String reversed = "";
                for (int j = name.length() - 1; j >= 0; j--) {
                    reversed += name.charAt(j);
                }
                reversedNames[i] = reversed;
            }
            return reversedNames;
        }


        public static char getLetterGrade(int score) {
            if (score >= 90 && score <= 100) {
                return 'A';
            } else if (score >= 80) {
                return 'B';
            } else if (score >= 70) {
                return 'C';
            } else if (score >= 60) {
                return 'D';
            } else {
                return 'F';
            }
        }


        public static String[] findFailingStudents(String[] names, int[] scores) {
            // Count how many students have < 60
            int failCount = 0;
            for (int score : scores) {
                if (score < 60) {
                    failCount++;
                }
            }


            String[] failingStudents = new String[failCount];
            int index = 0;
            for (int i = 0; i < scores.length; i++) {
                if (scores[i] < 60) {
                    failingStudents[index++] = names[i];
                }
            }
            return failingStudents;
        }

        public static void main(String[] args) {
            String[] students = {"Alice", "Bob", "Charlie", "Diana"};
            int[] scores = {95, 67, 45, 78};


            String[] reversedNames = reverseStudentNames(students);
            System.out.println("Reversed Student Names:");
            for (String name : reversedNames) {
                System.out.println(name);
            }


            System.out.println("\nLetter Grades:");
            for (int i = 0; i < students.length; i++) {
                char grade = getLetterGrade(scores[i]);
                System.out.println(students[i] + ": " + grade);
            }


            String[] failing = findFailingStudents(students, scores);
            System.out.println("\nStudents who need to retake exam:");
            for (String name : failing) {
                System.out.println(name);
            }
        }
    }

