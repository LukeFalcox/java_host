public abstract class CriadorRelatorio {
  abstract Relatorio criarRelatorio();

  public void rel(){
    Relatorio relatorio = criarRelatorio();
    relatorio.gerarCabecalho();
    relatorio.gerarCorpo();
    relatorio.gerarRodape();
  }
}
