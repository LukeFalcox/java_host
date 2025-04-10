public class CriadorPdf extends CriadorRelatorio{
  @Override
  Relatorio criarRelatorio() {
    return new RelatorioPdf();
  }
}
