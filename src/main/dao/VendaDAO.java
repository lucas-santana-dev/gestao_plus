package main.dao;

import java.io.*;

import main.model.VendaModel;

public class VendaDAO {

    private static final String DIRECTORY_PATH = "src/main/database/";
    private static final String FILENAME = DIRECTORY_PATH + "vendas.txt";

    // Método para salvar uma nova venda no arquivo TXT
    public static boolean salvarVenda(VendaModel venda) {
        File file = new File(FILENAME);
        if (!file.exists()) {
            // Se o arquivo não existir, cria o diretório e o arquivo
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false; // Retorna false se ocorrer uma exceção ao criar o arquivo
            }
        }

        try (FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println(formatarVendaParaTexto(venda)); // Aqui o cliente é formatado como texto e escrito no arquivo
            return true; // Retorna true se o cliente for salvo com sucesso
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Retorna false se ocorrer uma exceção ao escrever no arquivo
        }
    }

    // Método auxiliar para formatar uma venda como uma linha de texto
    private static String formatarVendaParaTexto(VendaModel venda) {
        return venda.getCliente() + ";" +
                venda.getFormaPagamento() + ";" +
                venda.getProdutos() + ";" +
                venda.getValorCompra();
    }
}
