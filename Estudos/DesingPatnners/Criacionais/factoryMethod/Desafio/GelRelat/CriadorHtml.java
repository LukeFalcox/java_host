public class CriadorHtml extends CriadorRelatorio{
  @Override
  Relatorio criarRelatorio() {
    return new RelatoriHtml();
  }
}
