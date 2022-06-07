import java.text.ParseException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    static ArrayList<Course> coursesAll = new ArrayList<>();
    static ArrayList<Student> studentsAll = new ArrayList<>();
    static ArrayList<Assignment> assignmentsAll = new ArrayList<>();
    static ArrayList<Trainer> trainersAll = new ArrayList<>();
    static ArrayList<CourseInformantion> courseInfoList = new ArrayList<>();


    public static void main(String[] args) throws ParseException {

        Scanner input = new Scanner(System.in);
        int userChoice;
        int userChoice2;

        userChoice = choiseMenu1();

        switch (userChoice) {

            case 1:

                do {

                    userChoice2 = menu2();

                    switch (userChoice2) {

                        case 1:
                            boolean flagStp = true;
                            String userStudentPrintChoice;

                            do {
                                Student student = inputNewStudent();
                                studentsAll.add(student);
                                printAllStudentsManual();
                                System.out.println("Would you like to Add an Other Student?"
                                        + "\n1 for Yes."
                                        + "\n2 for No.");
                                userStudentPrintChoice = input.nextLine();

                                if ("1".equals(userStudentPrintChoice)) {
                                } else if ("2".equals(userStudentPrintChoice)) {
                                    flagStp = false;
                                } else {
                                    System.out.println("Please Give 1 or 2.");
                                }
                            } while (flagStp == true);

                            break;

                        case 2:

                            boolean flagTtp = true;
                            do {
                                Trainer trainer = inputNewTrainer();
                                trainersAll.add(trainer);
                                printAllTrainersManual();
                                System.out.println("Would you like to Add an Other Trainer?"
                                        + "\n1 for Yes."
                                        + "\n2 for No.");
                                String userTrainerPrintChoice = input.nextLine();

                                if ("1".equals(userTrainerPrintChoice)) {
                                } else if ("2".equals(userTrainerPrintChoice)) {
                                    flagTtp = false;
                                } else {
                                    System.out.println("Please give 1 or 2.");
                                }
                            } while (flagTtp == true);
                            break;

                        case 3:
                            boolean flagAtp = true;
                            do {
                                Assignment assignment = inputNewAssignment();
                                assignmentsAll.add(assignment);
                                printAllAssignmentManual();
                                System.out.println("Would you like to Add an Other Assignment?"
                                        + "\n1 for Yes."
                                        + "\n2 for No.");
                                String userAssignmentPrintChoice = input.nextLine();
                                if ("1".equals(userAssignmentPrintChoice)) {
                                } else if ("2".equals(userAssignmentPrintChoice)) {
                                    flagAtp = false;
                                } else {
                                    System.out.println("Please give 1 or 2.");
                                }

                            } while (flagAtp == true);
                            break;

                        case 4:

                            boolean flagCtp = true;

                            do {

                                Course course = inputNewCourse();
                                coursesAll.add(course);
                                printAllCoursesManual();
                                System.out.println("Would you like to Add an Other Course?"
                                        + "\n1 for Yes."
                                        + "\n2 for No.");
                                String userCoursePrintChoice = input.nextLine();
                                if ("1".equals(userCoursePrintChoice)) {
                                } else if ("2".equals(userCoursePrintChoice)) {
                                    flagCtp = false;
                                } else {
                                    System.out.println("Please give 1 or 2.");
                                }

                            } while (flagCtp == true);
                            break;

                        case 5:

                            studentPerCourseInput();
                            break;
                        case 6:
                            //Adding  Courses to trainer.
                            printAddCoursesToTrainerManual();

                            break;
                        case 7:
                            //Adding Courses to Student
                            printAddCoursesToStudentManual();

                            break;

                        case 8:
                            //Adding Assignments to Students.
                            printAddAssignmentsToStudentsManual();

                            break;

                        case 9:
                            printStudentWithMoreClasses();
                            break;

                        case 10:
                            printStudentsAssignmentsWithInDayOfWeek();
                            break;

                    }

                } while (userChoice2 != 0);
                break;

            case 2:

                addDummyData();
                createCourseInformationListSynth();

                printAllStudentsSynth(studentsAll);
                System.out.println("Part1 Complete");
                System.out.println();

                printAllTrainersSynth(trainersAll);
                System.out.println("Part2 Complete");
                System.out.println();

                printAllAssignmentsSyth(assignmentsAll);
                System.out.println("Part3 Complete");
                System.out.println();

                printAllCoursesSynth(coursesAll);
                System.out.println("Part4 Complete");
                System.out.println();

                printStudentPerCourse();
                System.out.println("Part5 Complete");
                System.out.println();

                printTrainersPerCourse(courseInfoList);
                System.out.println("Part6 Complete");
                System.out.println();

                printAssignmentsPerCourse(courseInfoList);
                System.out.println("Part7 Complete");
                System.out.println();

                printAssignmentsPerStudentSynth();
                System.out.println("Part8 Complete");
                System.out.println();

                printStudentWithMoreClassesSynt();
                System.out.println("Part9 Complete");
                System.out.println();

                printStudentsAssignmentsWithInDayOfWeekSynth(courseInfoList);
                System.out.println("Part10 Complete");
                System.out.println();
                break;

            case 3:
                System.out.println("Have a nice day goodBye!");
                break;
            default:
                System.out.println("Lalala");

        }

    }

    public static void printStudentWithMoreClasses() {

        for (Student studentTest : studentsAll) {
            for (Course studentCourse : studentTest.getCourse()) {
                if (studentTest.getCourse().size() != 1) {
                    System.out.println("The Student with First&Last Name: " + studentTest.getFirstName()
                            + " " + studentTest.getLastName() + "\nHas Course With Title And Stream: "
                            + studentCourse.getTitle() + " " + studentCourse.getStream());

                } else {
                    System.out.println("None Found");
                }
            }

        }

    }

    public static void printStudentWithMoreClassesSynt() {

        for (Student studentsRun : studentsAll) {
            for (Course studentsCourses : studentsRun.getCourse()) {

                if (studentsRun.getCourse().size() != 1) {

                    System.out.println("The Student with First&Last Name: " + studentsRun.getFirstName()
                            + " " + studentsRun.getLastName() + " Birthday: "
                            + DateUtilities.convertDateToString(studentsRun.getDateOfBirth())
                            + " With Tuition fees: " + studentsRun.getTuitionFees()
                            + "\nHas Course With Title And Stream: "
                            + studentsCourses.getTitle() + " " + studentsCourses.getStream());

                    System.out.println();
                }

            }

        }
    }

    public static int choiseMenu1() {

        Scanner input = new Scanner(System.in);

        int userChoise = 0;

        while (userChoise < 1 || userChoise > 3) {

            System.out.println("Greatings would  you like to input date or use Synthetic Data?:"
                    + "\n" + " 1 for manual input."
                    + "\n" + " 2 for use of Synthetic Data."
                    + "\n" + " 3 to end the Programm.");

            try {
                userChoise = input.nextInt();

            } catch (Exception e) {
                String blackHole = input.nextLine();
                System.out.println("Please give an input of integer number from (1,2,3) ");

                System.out.println(blackHole + " Is the error please give Correct input");
            }

        }
        return userChoise;
    }

    public static void printAllStudentsSynth(ArrayList<Student> students) {

        for (Student student : students) {
            System.out.println("The Name and Lastname of the Student is: "
                    + student.getFirstName() + " "
                    + student.getLastName() + " "
                    + "\nBirthday: " + DateUtilities.convertDateToString(student.getDateOfBirth())
                    + " Tuition fees are: " + student.getTuitionFees());

        }
    }

    public static void printAllTrainersSynth(ArrayList<Trainer> trainers) {

        for (Trainer trainer : trainers) {
            System.out.println("The Name and Lastname of the Trainer: "
                    + trainer.getFirstName() + " " + trainer.getLastName()
                    + "\nThe Trainers subjects are: " + trainer.getSubject());

        }

    }

    public static void printAllAssignmentsSyth(ArrayList<Assignment> assignments) {

        for (Assignment assignment : assignments) {
            System.out.println("The name of Assignment: " + assignment.getTitle() + " "
                    + "The Description is: " + assignment.getDescription()
                    + "\nThe given Date of the Assignment is: " + DateUtilities.convertDateToString(assignment.getGivenDate())
                    + " " + "The Dealine Date is: " + DateUtilities.convertDateToString(assignment.getDeadLine()) + " "
                    + "\nThe Oral Mark is: " + assignment.getOralMark() + " "
                    + "The Total Mark is: " + assignment.getTotalMark());
            System.out.println();
        }

    }

    public static void printAllCoursesSynth(ArrayList<Course> courses) {

        for (Course course : courses) {
            System.out.println("The Title of the Course is: " + course.getTitle() + " "
                    + "The Stream of the Course is: " + course.getStream() + "\n"
                    + "The Starting Date is " + DateUtilities.convertDateToString(course.getStartasDate())
                    + " " + "The End Date is: " + DateUtilities.convertDateToString(course.getEndDate()));

        }
    }

    public static void printTrainersPerCourse(ArrayList<CourseInformantion> courseInfoList) {

        for (CourseInformantion course : courseInfoList) {
            System.out.println();
            System.out.println("The Course with Name, Stream and Type: " + course.getCourse().getTitle()
                    + " " + course.getCourse().getStream()
                    + " " + course.getCourse().getType() + "\nWith Start And End Date: "
                    + DateUtilities.convertDateToString(course.getCourse().getStartasDate()) + " "
                    + DateUtilities.convertDateToString(course.getCourse().getEndDate()));
            for (Trainer trainer : course.getTrainer()) {
                System.out.println("Has a Trainer with Fist, Last Name and Subject :" + trainer.getFirstName() + " " + trainer.getLastName()
                        + " " + trainer.getSubject());

            }

        }
    }

    public static void printAssignmentsPerCourse(ArrayList<CourseInformantion> courseInfoList) {

        for (CourseInformantion course : courseInfoList) {
            System.out.println();
            System.out.println("The Course with Name, Stream and Type: " + course.getCourse().getTitle()
                    + " " + course.getCourse().getStream()
                    + " " + course.getCourse().getType() + "\nWith Start And End Date: "
                    + DateUtilities.convertDateToString(course.getCourse().getStartasDate()) + " "
                    + DateUtilities.convertDateToString(course.getCourse().getEndDate()));
            for (Assignment assignment : course.getAssignment()) {
                System.out.println("Has an assignment with Title, Description: " + assignment.getTitle()
                        + " " + assignment.getDescription()
                        + "\nWith Given and End Date: " + DateUtilities.convertDateToString(assignment.getGivenDate())
                        + " " + DateUtilities.convertDateToString(assignment.getDeadLine())
                        + "\nAnd Oral and Total Mark: " + assignment.getOralMark() + " " + assignment.getTotalMark());

            }
        }
    }

    public static void printAssignmentsPerStudentSynth() {

        for (Student student : studentsAll) {
            System.out.println("The Student with First&Last Name: " + student.getFirstName() + " " + student.getLastName()
                    + "\nWith date of birth and tuitions fees: " + DateUtilities.convertDateToString(student.getDateOfBirth()) + " " + student.getTuitionFees());

            for (Assignment assignment : student.getAssignments()) {
                System.out.println("The Assignment with Tile & Description: "
                        + assignment.getTitle() + " " + assignment.getDescription()
                        + "\nWith given date,deadline and submission date: "
                        + DateUtilities.convertDateToString(assignment.getGivenDate()) + " " + DateUtilities.convertDateToString(assignment.getDeadLine()) + " "
                        + DateUtilities.convertDateToString(assignment.getSubDateTime()));
            }
        }
    }

    public static void printStudentPerCourse() {

        for (Course course : coursesAll) {
            System.out.println("For the Course with Title: " + course.getTitle());

            for (Student student : studentsAll) {

                for (Course courseStudent : student.getCourse()) {
                    if (courseStudent.getTitle().equals(course.getTitle())) {
                        System.out.println("The Students are: " + student.getFirstName() + " " + student.getLastName());

                    }
                }
            }
        }
    }

    public static void addDummyData() {

        try {

            coursesAll = DummyData.createArrayListCourseSynth();
            assignmentsAll = DummyData.createListAssigmentsAllSynth();
            studentsAll = DummyData.createListStudentsAllWithcCouresAndAssigmentsSynth();
            trainersAll = DummyData.createListTrainersALLWithCouresSynth();

        } catch (ParseException ex) {
            System.out.println("Wrong Input of Date");
        }
    }

    public static int menu2() {

        Scanner input = new Scanner(System.in);

        boolean flag1 = false;
        String userChoice2;
        int userChoiceB = -1;
        while (flag1 == false) {

            System.out.println("Greattings would  you like to input Data or use Synthetic Data?:"
                    + "\n" + " 1 for Student Creation."
                    + "\n" + " 2 for Trainer Creation."
                    + "\n" + " 3 for Assignments Creation."
                    + "\n" + " 4 for Courses Creation."
                    + "\n" + " 5 for Adding Course to Assignments."
                    + "\n" + " 6 for Adding Courses to Trainers."
                    + "\n" + " 7 for Adding Courses to Student. "
                    + "\n" + " 8 for Adding Assignments to Student."
                    + "\n" + " 9 for Students with more than one Assignment."
                    + "\n" + " 10 to Check Assignments for submission on requested Date."
                    + "\n" + " 0 for Exit.");

            userChoice2 = input.nextLine();

            try {
                userChoiceB = Integer.parseInt(userChoice2);
            } catch (NumberFormatException e) {

                System.out.println("Please give Correct input type Integer.");

            }

            if (userChoiceB < 0 || userChoiceB > 10) {

                System.out.println("Please give an input of integer number from (0,1,2,3,4,5,6,7,8,9,10) ");

            } else {
                flag1 = true;
            }
        }

        return (int) userChoiceB;

    }

    public static Assignment inputNewAssignment() throws ParseException {

        Scanner input = new Scanner(System.in);

        System.out.println("Please give Assignment's title: ");
        String assignmentTitle = input.nextLine();

        System.out.println("Please give Assignment's description");
        String assignmentDescription = input.nextLine();

        System.out.println("Please give Assignment's givenDate in the following format (dd/MM/YYYY)");

        String assignmentGivenDate = "00/00/0000";

        boolean invalidInput = true;
        do {

            assignmentGivenDate = input.nextLine();
            Date temp = DateUtilities.convertedDateFromString(assignmentGivenDate);
            if (temp == null) {

                System.out.println("Please Try again to give Correct Date Format (dd/MM/YYYY) for example 31/03/2021");
            } else {
                invalidInput = false;
            }

        } while (invalidInput == true);
        String assignmentDeadLine = "00/00/0001";
        System.out.println("Please give Assignment's deadLine in the following format (dd/MM/YYYY)");
        invalidInput = true;

        do {
            assignmentDeadLine = input.nextLine();
            Date temp = DateUtilities.convertedDateFromString(assignmentDeadLine);
            if (temp != null) {

                if (temp.before(DateUtilities.convertedDateFromString(assignmentGivenDate))) {

                    System.out.println("Please Try again to give Correct Date after Given Date");
                } else {
                    invalidInput = false;
                }
            } else {
                System.out.println("Please give correct Date Format dd/MM/YYYY example 30/03/2021");
            }

        } while (invalidInput == true);
        String assignmentSubDateTime = "00/00/0000";

        System.out.println("Please give Assignment's subDateTime in the following format (dd/MM/YYYY)");
        invalidInput = true;
        do {
            assignmentSubDateTime = input.nextLine();
            Date temp1 = DateUtilities.convertedDateFromString(assignmentSubDateTime);
            if (temp1 != null) {

                if (temp1.after(DateUtilities.convertedDateFromString(assignmentDeadLine))
                        || temp1.before(DateUtilities.convertedDateFromString(assignmentGivenDate))) {

                    System.out.println("Please Try again to give Correct Date before DeadLine and after Given Date");
                } else {
                    invalidInput = false;
                }
            } else {
                System.out.println("Please give Correct Date form dd//MM/YYYY example 31/03/2021.");
            }

        } while (invalidInput == true);

        float assignmentOralMark = -1;
        invalidInput = true;

        System.out.println(
                "Please give Assignment's oralMark");
        while ((assignmentOralMark < 0 || assignmentOralMark > 100) && invalidInput
                == true) {

            try {

                String assignmentOralMark1 = input.nextLine();
                assignmentOralMark = Float.parseFloat(assignmentOralMark1);
            } catch (NumberFormatException | InputMismatchException er) {

                System.out.println("Please Try again to give Correct Mark Float from 0 to 100.");
            }

            if ((assignmentOralMark < 0 || assignmentOralMark > 100)) {
                System.out.println("Please try again");
            } else {
                invalidInput = false;
            }
        }

        invalidInput = true;
        float assignmentTotalMark = -1;

        System.out.println(
                "Please give Assignment's totalMark");
        while ((assignmentTotalMark < 0 || assignmentTotalMark > 100) && invalidInput
                == true) {

            try {
                String assignmentTotalMark1 = input.nextLine();
                assignmentTotalMark = Float.parseFloat(assignmentTotalMark1);
            } catch (NumberFormatException | InputMismatchException er) {

                System.out.println("Please Try again to give Correct Mark Float from 0 to 100.");
            }
            if (assignmentTotalMark >= 0 && assignmentTotalMark <= 100) {
                invalidInput = false;
            } else {
                System.out.println("Please try again");
            }
        }
        //Created a Assignment
        Assignment assignment = new Assignment(assignmentTitle, assignmentDescription,
                assignmentDeadLine, assignmentGivenDate, assignmentSubDateTime, assignmentOralMark, assignmentTotalMark);

        return assignment;
    }

    public static Student inputNewStudent() throws ParseException {

        Scanner input = new Scanner(System.in);

        System.out.println("Please give the new Student's information first name");
        String studentFistName = input.nextLine();

        System.out.println("Pleas give the new Student's information last name");
        String studentLastName = input.nextLine();

        String studentDateOfBirth = "00/00/0000";

        System.out.println("Please give the new Student's information date of birth in the following format (dd/MM/YYYY)");
        boolean invalidInput = true;
        while (invalidInput == true) {

            studentDateOfBirth = input.nextLine();

            Date test = DateUtilities.convertedDateFromString(studentDateOfBirth);
            if (test != null) {
                invalidInput = false;
            }
        }

        String studentTuitionFees;
        invalidInput = true;
        int tuitionTest = -1;
        System.out.println("Please give the new Student's tuitionFees");

        do {
            studentTuitionFees = input.nextLine();

            try {
                tuitionTest = Integer.parseInt(studentTuitionFees);

            } catch (NumberFormatException e) {

                System.out.println("Please Try again to give a integer For tuition");

            }
            if (tuitionTest < 0) {
                System.out.println("Please Give Correct number for Tuition Fees >0");
            } else {
                invalidInput = false;
            }

        } while (invalidInput);

        //Created a Student
        Student student = new Student(studentFistName, studentLastName, (studentDateOfBirth),
                tuitionTest);

        return student;
    }

    public static Trainer inputNewTrainer() {

        Scanner input = new Scanner(System.in);

        System.out.println("Please give Trainer's first");
        String trainerFirstName = input.nextLine();

        System.out.println("Please give Trainer's last name");
        String trainerLastName = input.nextLine();

        System.out.println("Please give Trainer's Subject");
        String trainerSubject = input.nextLine();

        Trainer trainer = new Trainer(trainerFirstName, trainerLastName,
                trainerSubject);

        return trainer;
    }

    public static Course inputNewCourse() throws ParseException {

        Scanner input = new Scanner(System.in);
        System.out.println("Please give Course Title");

        String courseTitle = input.nextLine();
        System.out.println("Please give Course Stream");

        String courseStream = input.nextLine();
        System.out.println("Please give Course Type");

        String courseType = input.nextLine();
        String courseStart_Date = "00/00/0000";

        boolean invalidInput = true;
        System.out.println("Please give Course start_date in the following format (dd/MM/YYYY)");
        Date test1 = DateUtilities.convertedDateFromString("00/00/0000");
        do {

            courseStart_Date = input.nextLine();

            test1 = DateUtilities.convertedDateFromString(courseStart_Date);
            if (test1 == null) {
                System.out.println("Please try Again");

            } else {
                invalidInput = false;
            }

        } while (invalidInput == true);

        String courseEnd_Date = "00/00/0001";
        invalidInput = true;

        System.out.println("Please give Course end_date in the following format (dd/MM/YYYY)");
        Date test = DateUtilities.convertedDateFromString("00/00/0001");
        do {
            courseEnd_Date = input.nextLine();
            test = DateUtilities.convertedDateFromString(courseEnd_Date);
            if (test != null) {

                if (test.before(DateUtilities.convertedDateFromString(courseStart_Date))) {
                    System.out.println("Please Try again to give Correct Date after Start_Date");
                } else {
                    invalidInput = false;
                }

            } else {
                System.out.println("Please try again Give Correct Date input example 31/03/2021.");
            }
        } while (invalidInput == true);

        Course course = new Course(courseTitle, courseStream, courseType,
                courseStart_Date, courseEnd_Date);

        return course;

    }


    public static void createCourseInformationListSynth() throws ParseException {

        ArrayList<Student> student01 = new ArrayList<>();

        student01.add(studentsAll.get(0));
        student01.add(studentsAll.get(1));

        ArrayList<Student> student02 = new ArrayList<>();
        student02.add(studentsAll.get(2));
        student02.add(studentsAll.get(1));

        ArrayList<Trainer> trainers01 = new ArrayList<>();
        trainers01.add(trainersAll.get(0));
        trainers01.add(trainersAll.get(1));
        trainers01.add(trainersAll.get(2));

        ArrayList<Trainer> trainers02 = new ArrayList<>();
        trainers02.add(trainersAll.get(3));
        trainers02.add(trainersAll.get(2));
        trainers02.add(trainersAll.get(1));

        ArrayList<Assignment> assignmentsSt0 = new ArrayList<>();
        assignmentsSt0.add(assignmentsAll.get(0));
        assignmentsSt0.add(assignmentsAll.get(1));

        ArrayList<Assignment> assignmentsSt1 = new ArrayList<>();
        assignmentsSt1.add(assignmentsAll.get(3));
        assignmentsSt1.add(assignmentsAll.get(4));

        Course course0 = new Course("Course1", "Stream1", "FullTime", "01/03/2021", "01/07/2021");
        Course course1 = new Course("Course2", "Stream1", "ParTime", "01/03/2021", "01/09/2021");

        CourseInformantion courseInfo0 = new CourseInformantion(course0, student01, trainers01, assignmentsSt0);
        CourseInformantion courseInfo1 = new CourseInformantion(course1, student01, trainers02, assignmentsSt1);

        courseInfoList.add(courseInfo0);
        courseInfoList.add(courseInfo1);

    }

    public static Course getCourseAfromCoursesAll(ArrayList<Course> coursesAll, String courseTitle) throws
            ParseException {
        Scanner input = new Scanner(System.in);
        Course course = new Course("null", "null", "null", "00/00/00", "00/00/00");

        for (int i = 0; i < coursesAll.size(); i++) {
            if (coursesAll.get(i).getTitle().equals(courseTitle)) {
                course = coursesAll.get(i);

            }
        }
        return course;
    }

    public static void createArrayListCourseToStudentSynth() {

        studentsAll.get(0).addCourse(coursesAll.get(0));
        studentsAll.get(0).addCourse(coursesAll.get(1));
        studentsAll.get(1).addCourse(coursesAll.get(2));
        studentsAll.get(2).addCourse(coursesAll.get(1));
        studentsAll.get(2).addCourse(coursesAll.get(2));

    }

    public static void studentPerCourseInput() {
        Scanner input = new Scanner(System.in);
        String userCourseTitle = "";

        while (true) {

            System.out.println("Please give Course Title or input end to end the selection.");
            userCourseTitle = input.nextLine();
            boolean flag = false;

            if (userCourseTitle.equals("end")) {

                break;
            }

            for (Course courseChoice : coursesAll) {

                if (courseChoice.getTitle().equals(userCourseTitle)) {
                    System.out.println("Found: " + courseChoice.getTitle());
                    int choiceContiniue;
                    do {
                        System.out.println("Please give Assignments Title to impliment to Course.");
                        String userAssignmentsTitle = input.nextLine();

                        for (Assignment assignmentChoice : assignmentsAll) {
                            if (userAssignmentsTitle.equals(assignmentChoice.getTitle())) {

                                assignmentChoice.setCourse(courseChoice);
                                flag = true;
                                break;
                            }
                            System.out.println("For the course with Title: " + courseChoice.getTitle());
                            System.out.println("The Course Assignments are: " + assignmentChoice.getTitle());
                        }
                        if (flag) {
                            break;
                        }
                        System.out.println("Would you like to add an Other Assignment to the Course? "
                                + "\n1" + " to continue."
                                + "\n2" + " to stop.");
                        choiceContiniue = input.nextInt();

                    } while (choiceContiniue == 2);

                }

            }
            if (!flag) {
                System.out.println("Something went Wrong Course Title Assignment Title of not Found");
            }

        }

    }

    public static void printAddCoursesToTrainerManual() {
        Scanner input = new Scanner(System.in);
        String userCourseTitle1 = "";
        while (true) {


            System.out.println("Please give Course Title or input end to end the selection.");

            userCourseTitle1 = input.nextLine();
            boolean flag1 = false;

            if (userCourseTitle1.equals("end")) {

                break;
            }

            for (Course courseChoice1 : coursesAll) {

                if (courseChoice1.getTitle().equals(userCourseTitle1)) {
                    System.out.println("Found" + courseChoice1.getTitle());
                    int choiceContinue1;
                    do {

                        System.out.println("Please give Trainer Name (ID) to add Course.");
                        String userTrainerName = input.nextLine();

                        for (Trainer trainerChoice : trainersAll) {

                            if (userTrainerName.equals(trainerChoice.getFirstName())) {

                                trainerChoice.addCourse(courseChoice1);
                                flag1 = true;
                                break;
                            }
                            System.out.println("The Trainer with: " + trainerChoice.getFirstName()
                                    + " " + trainerChoice.getLastName()
                                    + " " + trainerChoice.getSubject()
                                    + "\nHas Course with Title and Stream: "
                                    + courseChoice1.getTitle()
                                    + courseChoice1.getStream());

                        }

                        if (flag1) {

                            break;
                        }

                        System.out.println("Would you like to add Other Course to The Trainer?"
                                + "\n1" + " to continue."
                                + "\n2" + " to stop.");
                        choiceContinue1 = input.nextInt();

                    } while (choiceContinue1 == 2);
                }
            }
            if (!flag1) {
                System.out.println("Something went Wrong Title not Found or Trainer Not Found");
            }
        }
    }

    public static void printAddCoursesToStudentManual() {
        Scanner input = new Scanner(System.in);

        String userCourseTitle2 = "";
        while (true) {

            System.out.println("Please give Course Title or input end to end the selection.");
            userCourseTitle2 = input.nextLine();
            boolean flag2 = false;

            if (userCourseTitle2.equals("end")) {

                break;
            }

            for (Course courseChoice2 : coursesAll) {

                if (userCourseTitle2.equals(courseChoice2.getTitle())) {
                    System.out.println("Found: " + courseChoice2.getTitle());
                    int choiceContinue2;

                    do {
                        System.out.println("Please give Student Last Name (ID) to add Course.");
                        String userStudentLastName = input.nextLine();

                        for (Student studentChoice : studentsAll) {
                            if (userStudentLastName.equals(studentChoice.getLastName())) {

                                studentChoice.addCourse(courseChoice2);
                                flag2 = true;

                                break;

                            }
                            System.out.println("For Student with First&Last Name: "
                                    + studentChoice.getFirstName()
                                    + studentChoice.getLastName()
                                    + "\nThe Courses Title and Stream are: "
                                    + courseChoice2.getTitle() + " "
                                    + courseChoice2.getStream());

                        }
                        if (flag2) {
                            break;
                        }
                        System.out.println("Would you like to Add an Other Course to the Student?"
                                + "\n1" + "to continue."
                                + "\n2" + "to Stop.");

                        choiceContinue2 = input.nextInt();

                    } while (choiceContinue2 == 2);

                }
            }
            if (!flag2) {
                System.out.println("Something went Wrong Title not Found Or Student not Found");
            }

        }

    }

    public static void printAddAssignmentsToStudentsManual() {
        Scanner input = new Scanner(System.in);
        String userAssignmentChoice2 = "";


        while (true) {

            System.out.println("Please give  Assignment Tile or input end to end the selection. ");
            userAssignmentChoice2 = input.nextLine();
            boolean flag3 = false;

            if (userAssignmentChoice2.equals("end")) {
                break;
            }

            for (Assignment assignmentChoice2 : assignmentsAll) {

                if (userAssignmentChoice2.equals(assignmentChoice2.getTitle())) {

                    System.out.println("Found: " + assignmentChoice2.getTitle());
                    int choiceContinue3;
                    do {
                        System.out.println("Please give Student Last Name(ID) in order to add Assignments.");
                        String userStudentChoice = input.nextLine();

                        for (Student studentChoice2 : studentsAll) {

                            if (userStudentChoice.equals(studentChoice2.getLastName())) {
                                studentChoice2.addAssignment(assignmentChoice2);

                                flag3 = true;
                                break;
                            }
                            System.out.println("For the Student With First&Last Name: "
                                    + studentChoice2.getFirstName() + " " + studentChoice2.getLastName()
                                    + "\nThe Assignments are: " + assignmentChoice2.getTitle()
                                    + " " + assignmentChoice2.getDescription());
                        }
                        if (flag3) {
                            break;
                        }
                        System.out.println("Would you like to add an Other Assignment to the Student?"
                                + "\n1" + "to continiue"
                                + "\n2" + "to stop.");
                        choiceContinue3 = input.nextInt();

                    } while (choiceContinue3 == 2);
                }
            }
            if (!flag3) {
                System.out.println("Something went Wrong Assignment Tile not Found or Student Last Name not Found");

            }
        }
    }

    public static void printAllStudentsManual() {
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to print All Student's?"
                + "\n1 For Yes"
                + "\n2 For No");
        int userChoiceForStudentPrint = input.nextInt();
        if (userChoiceForStudentPrint == 1) {
            for (Student studentIn : studentsAll) {
                System.out.println("The Name&Last Name of the Student is: "
                        + studentIn.getFirstName() + " "
                        + studentIn.getLastName() + " "
                        + "\nBirthday: " + DateUtilities.convertDateToString(studentIn.getDateOfBirth())
                        + " Tuition fees are: " + studentIn.getTuitionFees());
            }
        }

    }

    public static void printAllTrainersManual() {
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to print All Trainer's "
                + "\n1 For Yes"
                + "\n2 For No");
        int userChoiceForTrainerPrint = input.nextInt();
        if (userChoiceForTrainerPrint == 1) {

            for (Trainer trainerIn : trainersAll) {
                System.out.println("The Name and Lastname of the Trainer: "
                        + trainerIn.getFirstName() + " " + trainerIn.getLastName()
                        + "\nThe Trainers subjects are: " + trainerIn.getSubject());

            }
        }
    }

    public static void printAllAssignmentManual() {
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to print All Assignment? "
                + "\n1 For Yes"
                + "\n2 For No");
        int userChoiseForAssignmentsPrint = input.nextInt();

        if (userChoiseForAssignmentsPrint == 1) {

            for (Assignment assignmentsIn : assignmentsAll) {
                System.out.println("The name of Assignment: " + assignmentsIn.getTitle() + " "
                        + "The Description is: " + assignmentsIn.getDescription()
                        + "\nThe given Date of the Assignment is: " + DateUtilities.convertDateToString(assignmentsIn.getGivenDate())
                        + " " + "The DeaLine Date is: " + DateUtilities.convertDateToString(assignmentsIn.getDeadLine()) + " "
                        + "\nThe Oral Mark is: " + assignmentsIn.getOralMark() + " "
                        + "The Total Mark is: " + assignmentsIn.getTotalMark());


            }

        }
    }

    public static void printAllCoursesManual() {
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to print All Courses?"
                + "\n1 For Yes"
                + "\n2 For No");
        int userChoiseforCoursePrint = input.nextInt();

        if (userChoiseforCoursePrint == 1) {

            for (Course courseIn : coursesAll) {
                System.out.println("The Title of the Course is: " + courseIn.getTitle() + " "
                        + "The Stream of the Course is: " + courseIn.getStream() + "\n"
                        + "The Starting Date is " + DateUtilities.convertDateToString(courseIn.getStartasDate())
                        + " " + "The End Date is: " + DateUtilities.convertDateToString(courseIn.getEndDate()));
            }

        }
    }

    public static void printStudentsAssignmentsWithInDayOfWeek() throws ParseException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please give a Date to check Student assignment deadlines in the following formant dd/MM/YYYY.");
        String dateToCheck = input.nextLine();

        Date convertedDateToCheck = DateUtilities.convertedDateFromString(dateToCheck);

        LocalDate convertedLocalDateToCheck = DateUtilities.convertedLocalDateFromDateSimple(convertedDateToCheck);

        int convertedLocalDateCheckDayOfWeek = convertedLocalDateToCheck.getDayOfWeek().getValue();
        //Sunday
        LocalDate startOfWeek = convertedLocalDateToCheck.minusDays(convertedLocalDateCheckDayOfWeek);
        //Saturday
        LocalDate endOfWeek = convertedLocalDateToCheck.plusDays(6 - convertedLocalDateCheckDayOfWeek);

        for (Student studentsIn : studentsAll) {

            for (Assignment assignmentIn : studentsIn.getAssignments()) {

                if (DateUtilities.convertedLocalDateFromDateSimple(assignmentIn.getDeadLine()).isAfter(startOfWeek)
                        && DateUtilities.convertedLocalDateFromDateSimple(assignmentIn.getDeadLine()).isBefore(endOfWeek)) {

                    System.out.println("The Student with First&Name: " + studentsIn.getFirstName() + " " + studentsIn.getLastName()
                            + "\nHas Assignment with Title and DeadLine: " + assignmentIn.getTitle() + " " + assignmentIn.getDeadLine());
                }
            }

        }

    }

    public static void printStudentsAssignmentsWithInDayOfWeekSynth(ArrayList courseInfoList) throws ParseException {

        Scanner input = new Scanner(System.in);
        System.out.println("The Date to check Student assignment deadlines is 31/03/2021");
        String dateToCheck = "31/03/2021";

        Date convertedDateToCheck = DateUtilities.convertedDateFromString(dateToCheck);

        LocalDate convertedLocalDateToCheck = DateUtilities.convertedLocalDateFromDateSimple(convertedDateToCheck);

        int convertedLocalDateCheckDayOfWeek = convertedLocalDateToCheck.getDayOfWeek().getValue();
        //Sunday
        LocalDate startOfWeek = convertedLocalDateToCheck.minusDays(convertedLocalDateCheckDayOfWeek);
        //Saturday
        LocalDate endOfWeek = convertedLocalDateToCheck.plusDays(6 - convertedLocalDateCheckDayOfWeek);

        for (Student studentsIn : studentsAll) {

            for (Assignment assignmentIn : studentsIn.getAssignments()) {

                if (DateUtilities.convertedLocalDateFromDateSimple(assignmentIn.getDeadLine()).isAfter(startOfWeek)
                        && DateUtilities.convertedLocalDateFromDateSimple(assignmentIn.getDeadLine()).isBefore(endOfWeek)) {

                    System.out.println("The Student with First&Name: " + studentsIn.getFirstName() + " " + studentsIn.getLastName()
                            + "\nHas Assignment with Title and DeadLine: " + assignmentIn.getTitle() + " " + DateUtilities.convertDateToString(assignmentIn.getDeadLine()));
                }
            }

        }

    }
}
