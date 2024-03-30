package dao;

import model.ProdutoModel;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {


    private static final String DIRECTORY_PATH = "src/database/";
    private  static  final String FILENAME = DIRECTORY_PATH + "produtos.txt";

    public static boolean salvarProduto(ProdutoModel produto){
        File file = new File(FILENAME);
        if(!file.exists()){
            file.getParentFile().mkdirs();
            try{
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
                return false;
            }
        }

        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(formatarProdutoParaTexto(produto));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<ProdutoModel> carregarProdutos(){
        List<ProdutoModel> produtos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
            String line;
            while ((line = br.readLine()) != null ){
                ProdutoModel produto = parseProdutoFromTexto(line);
                if (produto != null){
                    produtos.add(produto);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return produtos;
    }

    private static String formatarProdutoParaTexto(ProdutoModel produto) {
        return produto.getId() + ";" +
                produto.getNomeProduto() + ";" +
                produto.getTipoProduto() + ";" +
                produto.getEstoque() + ";" +
                produto.getPrecoVenda() + ";" +
                produto.getPrecoCompra() + ";"+
                produto.getDataFabricacao() + ";"+
                produto.getDataValidade() + ";"
                ;
    }

    private static ProdutoModel parseProdutoFromTexto(String line){
        String[] parts = line.split(";");
        if (parts.length == 8){
            long id = Long.parseLong(parts[0]);
            String nomeProduto = parts [1];
            String tipoProduto = parts[2];
            double estoque = Double.parseDouble(parts[3]);
            float precoVenda = Float.parseFloat(parts[4]);
            float precoCompra = Float.parseFloat(parts[5]);
            LocalDate dataFabricacao = LocalDate.parse(parts[6]);
            LocalDate dataValidade = LocalDate.parse(parts[7]);
            return  new ProdutoModel(
                    id,
                    nomeProduto,
                    tipoProduto,
                    precoCompra,
                    precoVenda,
                    dataFabricacao,
                    dataValidade,
                    estoque
            );
        }
        return null;
    }

}
