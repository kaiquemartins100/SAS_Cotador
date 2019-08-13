package sulamerica.cotador;
import org.junit.runner.JUnitCore;

public class Starter 
{
	public static void main(String[] args) throws Exception {
		
		System.out.println("Início de execução");
		JUnitCore j = new JUnitCore();
//		j.run(cotador.sulamerica.Adesao.class);
//		j.run(cotador.sulamerica.ASO.class);
		j.run(sulamerica.cotador.Empresarial.class);
		
		Runtime.getRuntime().exec("cmd /c del %TEMP%\\*.* /f /s /q");
	}
}