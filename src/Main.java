import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Task task1 = new Task("Обучение на новом оборудовании", "узнать характеристики");
        Task task2 = new Task("Обучение на старом оборудовании", "узнать характеристики");
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        Epic epic1 = new Epic("Обучение программированию", "Чтобы погрузиться в мир IT");
        int epicId1 = taskManager.addEpic(epic1);
        SubTask subTask1 = new SubTask("Прочесть гайд", "Узнать теорию", epicId1);
        SubTask subTask2 = new SubTask("Выполнить практическое", "Подтвердить теорию", epicId1);
        taskManager.addSubTask(subTask1);
        taskManager.addSubTask(subTask2);
        Epic epic2 = new Epic("Общение с коллегами", "Налаживание коммуникации");
        int epicId2 = taskManager.addEpic(epic2);
        SubTask subTask3 = new SubTask("Митинг", "Google meets", epicId2);
        taskManager.addSubTask(subTask3);

        ArrayList<Task> tasksList = taskManager.getAllTask();
        System.out.println("List of the tasks:");
        for (Task task : tasksList) {
            System.out.println("task.id = " + task.id);
            System.out.println("title " + task.title);
            System.out.println("description " + task.description);
        }

        ArrayList<Epic> epicList = taskManager.getAllEpics();
        System.out.println("List of the epics:");
        for (Epic epic : epicList) {
            System.out.println("epic.id = " + epic.id);
            System.out.println("title  " + epic.title);
            System.out.println("description  " + epic.description);
        }


        ArrayList<SubTask> subTaskList = taskManager.getAllSubTask();
        System.out.println("List of the subTasks:");
        for (SubTask subTask : subTaskList) {
            System.out.println("subTask.id = " + subTask.id);
            System.out.println("title  " + subTask.title);
            System.out.println("description  " + subTask.description);
            System.out.println("epicId " + subTask.epicid);
        }
    }
}
