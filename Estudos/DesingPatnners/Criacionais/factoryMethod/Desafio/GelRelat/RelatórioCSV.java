public class RelatórioCSV implements Relatorio{
@Override
public void gerarCabecalho() {
  System.out.println("Cabeçalho criado CSV");
}

@Override
public void gerarCorpo() {
  System.out.println("Corpo criado CSV");
}

@Override
public void gerarRodape() {
  System.out.println("Rodapé Gerado CSV");
}

  
}