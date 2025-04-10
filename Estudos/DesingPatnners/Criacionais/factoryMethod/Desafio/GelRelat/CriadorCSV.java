public class CriadorCSV extends CriadorRelatorio{
  @Override
  Relatorio criarRelatorio() {
    return new RelatórioCSV();
  }
}
