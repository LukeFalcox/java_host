public class RelatorioPdf implements Relatorio{
  @Override
  public void gerarCabecalho() {
    System.out.println("Gerado Cabeçalho Pdf");
  }
  @Override
  public void gerarCorpo() {
    System.out.println("Gerado Corpo Pdf");
  }
  @Override
  public void gerarRodape() {
    System.out.println("Gerado Rodape Pdf");
  }
}
