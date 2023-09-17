package duke.task;
import duke.exception.DukeException;
import duke.exception.PositionException;
import duke.ui.Ui;

import java.util.ArrayList;

/**
 * Represents a List of Task.
 */
public class TaskList {
	private ArrayList<Task> taskList;

	/**
	 * @param taskList Represents the list of Task.
	 */
	public TaskList(ArrayList<Task> taskList) {
		this.taskList = taskList;
	}

	/**
	 * Initialises a new arrayList to store Task.
	 */
	public TaskList() {
		this.taskList = new ArrayList<Task>(100);
	}

	/**
	 * Add task to list.
	 * @param t Task to be added.
	 */
	public void add(Task t) {
		taskList.add(t);
	}

	/**
	 *  Remove task from taskList to be added into archive file
	 * @param position of task to be removed
	 * @return Task to be added to archvie file
	 */
	public Task toArchiveFile(int position) throws PositionException {
		if (position > taskList.size() || position < 0) {
			throw new PositionException("Can not archive beyond list");
		}
		return taskList.remove(position);
	}


	/**
	 * shows all tasks in the list
	 * @param ui outputs task list to user
	 */
	public String listAsString(Ui ui) {
		StringBuilder br = new StringBuilder();
		for (int i = 0; i < taskList.size(); i++) {
			br.append(i + 1).append(". ");
			br.append((taskList.get(i)).toString()).append("\n");
		}
		return ui.showList(br);
	}

	/**
	 * Marks task.
	 * @param toMark Whether to mark Task as done or not.
	 * @param pos Position of task to be marked, starting from 1.
	 * @throws DukeException If unable to mark task at specified idx.
	 */
	public void toMark(Boolean toMark, int pos, Ui ui) throws DukeException {
		assert(pos >= 0) : "can not mark or unmark negative position";
		if (pos > taskList.size()) {
			throw new DukeException("Trying to mark or unmark something beyond the list");
		}

		Task task = taskList.get(pos);
		if (toMark) {
			task.markAsDone();
		} else {
			task.unMark();
		}
	}
	/**
	 * Returns number of tasks remaining after deletion
	 * @return number task remaining after deletion
	 */

//	public String getMainRemaining(boolean isMain) {
//		return isMain ?
//				Integer.toString(taskList.size() - 1) :
//				Integer.toString(taskList.size() - 1);
//	}

	public String getSize() {
		return Integer.toString(taskList.size());
	}

	/**
	 * Returns String representation of task at a given index, starting from 0.
 	 * @param i Index of Task in taskList that we are interested in.
	 * @return String representation of Task.
	 */
	public Task getTask(int i) {
		return taskList.get(i);
	}

	/**
	 * Finds task by keyword in task list
	 * @param keyWord word we are searching task by
	 * @return String representation of task which we output to user later on
	 */

	public StringBuilder findTaskToString(String keyWord) {
		int count = 1;
		StringBuilder br = new StringBuilder();
		for (Task t: taskList) {
			String[] words = t.toString().split(" ");
			for (String w: words) {
				if (w.equals(keyWord)) {
					br.append(count).append(". ").append(t.toString()).append("\n");
				}
			}
			count++;
		}
		return br;
	}

	/**
	 * clears taskList
	 */
	public void clearTask() {
		taskList = new ArrayList<>(100);
	}
}
