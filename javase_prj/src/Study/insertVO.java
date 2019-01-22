package Study;

public class insertVO {

	private String name;
	private int javaScore, oracleScore;
	
	public insertVO(String name, int javaScore, int oracleScore) {
		super();
		this.name = name;
		this.javaScore = javaScore;
		this.oracleScore = oracleScore;
	}
	
	public String getName() {
		return name;
	}
	public int getJavaScore() {
		return javaScore;
	}
	public int getOracleScore() {
		return oracleScore;
	}

	@Override
	public String toString() {
		return "insertVO [name=" + name + ", javaScore=" + javaScore + ", oracleScore=" + oracleScore + "]";
	}
	
	

	
	
}//class
