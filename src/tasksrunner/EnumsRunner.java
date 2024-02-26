package tasksrunner;

public class EnumsRunner {
	
	public enum Rainbow{
		Violet(1),
		Indigo(2),
		Blue(3),
		Green(4),
		Yello(5),
		Orange(6),
		Red(7);
		
		int colorCode;
		Rainbow(int colorCode) {
			this.colorCode = colorCode;
		}
		public int getColorCode() {
			return colorCode;					
		}		
	}
	
	public Rainbow[] taskRunner() {
		Rainbow[] totalColors = Rainbow.values();
		return totalColors; 
	}
}
