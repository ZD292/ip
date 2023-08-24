public class Task {
	protected String description;
	protected boolean isDone;

	public Task(String description) {
		this.description = description;
		this.isDone = false;
	}
	public void markAsDone() {
		this.isDone = true;
	}

	public void unMark() {
		this.isDone = false;
	}

	public String getTask() {
		return isDone ? "[X]" : "[ ]";
	}
	@Override
	public String toString() {
		return isDone ? "[X]" + " " + this.description : "[ ]" + " " + this.description;
	}

}