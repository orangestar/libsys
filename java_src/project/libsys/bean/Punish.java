package project.libsys.bean;

public class Punish {

	private int id;
	
	private String cause;
	
	private boolean finished;
	
	private float money;
	
	private Lend lend;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public Lend getLend() {
		return lend;
	}

	public void setLend(Lend lend) {
		this.lend = lend;
	}

}
