package aluguel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import aluguel.Aluguel;

public class AluguebugParameterizedTest {

  private Aluguel aluguel;

  @BeforeEach
    public void init(){
        aluguel = new Aluguel();
    }

  @ParameterizedTest(name="String => Dia={0}")
  @CsvSource(value={
      "0:350:-1", "1:350:315.0", "2:350:315.0",
      "4:350:315", "5:350:315", "6:350:332.5",
      "9:350:332.5", "10:350:332.5", "11:350:350",
      "14:350:350", "15:350:350", "16:350:357.35",
      "29:350:361.9", "30:350:362.25", "31:350:-1"
    }, delimiter=':')
  public void test_analise_limite_WDSP(int dia, double valor, double result){
    double value = aluguel.insertProject(dia, valor);
		assertEquals(result, value, 0.01);
  }

  @ParameterizedTest(name="Sistematico => Dia={0}")
  @CsvSource(value={"22:350:359.45"}, delimiter=':')
  public void test_sistematico_WDSP(int dia, double valor, double result){
    double value = aluguel.insertProject(dia, valor);
		assertEquals(result, value, 0.01);
  }

  @ParameterizedTest(name="Pelo CSV => Dia={0}")
  @CsvFileSource(resources="/valores_teste.csv", delimiter=',')
  public void test_analise_limite_CSV_WDSP(int dia, double valor, double result){
    double value = aluguel.insertProject(dia, valor);
		assertEquals(result, value, 0.01);
  }
}
