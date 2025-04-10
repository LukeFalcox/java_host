public class Principal {
  public static void main(String[] args) {
    CriadorRelatorio criadorRelatorio;
    criadorRelatorio = new CriadorCSV();
    criadorRelatorio.rel();
    criadorRelatorio = new CriadorHtml();
    criadorRelatorio.rel();
    criadorRelatorio = new CriadorPdf();
    criadorRelatorio.rel();
  }
}
