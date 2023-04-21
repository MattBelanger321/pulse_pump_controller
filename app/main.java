package app;

class main {

	public static void main(String[] args) throws Exception {

		Arduino arduino = new Arduino();

		main_frame arduino_gui = new main_frame(arduino);
	}
}