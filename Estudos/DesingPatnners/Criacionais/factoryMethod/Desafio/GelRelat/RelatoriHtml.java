public class RelatoriHtml implements Relatorio{
  @Override
  public void gerarCabecalho() {
    System.out.println("Gerado Cabecalho Html");
  }
  @Override
  public void gerarCorpo() {
    System.out.println("Gerado Corpo Html");
  }
  @Override
  public void gerarRodape() {
    System.out.println("Gerado Rodape Html");
  }

  
  
}