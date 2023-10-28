import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class TaskManager {

    public HashMap<Integer, SubTask> subTasks = new HashMap<>();
    public HashMap<Integer, Task> tasks = new HashMap<>();
    public HashMap<Integer, Epic> epics = new HashMap<>();
    public int nextId = 0;

    public int addSubTask(SubTask subTask) {
        subTask.id = ++nextId;
        subTasks.put(nextId, subTask);
        Epic epic = epics.get(subTask.epicid);
        if (epic.status == Status.DONE) {
            epic.status = Status.IN_PROGRESS;
        }
        return nextId;
    }

    public int addTask(Task task) {
        task.id = ++nextId;
        tasks.put(nextId, task);
        return nextId;
    }

    public int addEpic(Epic epic) {
        epic.id = ++nextId;
        epics.put(nextId, epic);
        return nextId;
    }

    public void updateSubTask(SubTask subTaskIn) {
        SubTask subTask = subTasks.get(subTaskIn.id);
        subTask.setStatus(subTaskIn.status);
        Epic epic = epics.get(subTask.epicid);
        if (subTaskIn.status == Status.DONE) {
            boolean allSubTasksDone = true;
            for (Integer subTasksId : epic.subTasksId) {
                SubTask currentSubTask = subTasks.get(subTasksId);
                if (currentSubTask.status != Status.DONE) {
                    allSubTasksDone = false;
                    break;
                }
            }
            if (allSubTasksDone) {
                epic.status = Status.DONE;
            }

        }
        else if (subTaskIn.status == Status.NEW) {
            boolean allSubTasksNew = true;
            for (Integer subTaskId : epic.subTasksId) {
                SubTask currentSubTask = subTasks.get(subTaskId);
                if (currentSubTask.status != Status.NEW) {
                    allSubTasksNew = false;
                    break;
                }
            }
            if (allSubTasksNew) {
                epic.status = Status.NEW;
            }
        } else {
            epic.status = Status.IN_PROGRESS;
        }

    }

    public void updateTask(Task taskIn) {

        Task obj1 = tasks.get(taskIn.id);
        obj1.setStatus(taskIn.status);

    }



    public ArrayList<SubTask> getAllSubTask () {
        Collection<SubTask> subTaskValues = subTasks.values();
        ArrayList<SubTask> subTaskArray = new ArrayList<>(subTaskValues);
        return subTaskArray;
    }

    public ArrayList<Task> getAllTask () {
       Collection<Task> taskValues = tasks.values();
       ArrayList<Task> tasksArray = new ArrayList<>(taskValues);
       return tasksArray;
    }
    public ArrayList<Epic> getAllEpics () {
        Collection<Epic> epicValues = epics.values();
        ArrayList<Epic> epicsArray = new ArrayList<>(epicValues);
        return epicsArray;
    }
    public void cleanSubTask () {
        tasks.clear();
    }
    public void cleanTask () {
        tasks.clear();
    }
    public void cleanEpic () {
        tasks.clear();
    }
    public Task getSubTaskById (int id) {
    return tasks.get(id);
    }
    public Task getTaskById (int id) {
        return tasks.get(id);
    }
    public Task getEpicById (int id) {
        return tasks.get(id);
    }
    public void deleteSubTask (int id) {
        tasks.remove(id);
    }
    public void deleteTask (int id) {
        tasks.remove(id);
    }
    public void deleteEpic (int id) {
        tasks.remove(id);
    }

}