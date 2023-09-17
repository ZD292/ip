package duke.command;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;
import duke.storage.Storage;

/**
 * Command to delete a task from the taskList
 */
public class DeleteCommand extends Command {
	private final int positionToDelete;
	public DeleteCommand(int positionToDelete) {
		this.positionToDelete = positionToDelete - 1;
	}
	/**
	 * Executes the delete command which deletes a task from taskList.
	 * Ui displays deleting to user.
	 * Deletion changes the contents in storage.
	 * Updates both storage and local taskList for reference during execution
	 * @param taskList list of tasks to execute.
	 * @param ui displays execution of deleting.
	 * @param storage can write tasks to store on the text file.
	 */
	@Override
	public String execute(TaskList taskList, Ui ui, Storage storage) {
		String remaining = taskList.getRemaining();
		Task task = taskList.getTask(positionToDelete);
		try {
			storage.deleteFromFile(positionToDelete);
			System.out.println(ui.showDelete(task, remaining));
			return ui.showDelete(task, remaining);
		} catch (IndexOutOfBoundsException e) {
			return e.getMessage();
//			System.out.println(e.getMessage());
		}
	}
}
