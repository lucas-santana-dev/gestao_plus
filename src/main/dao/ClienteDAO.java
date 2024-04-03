package main.dao;

import main.model.ClienteModel;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private static final String DIRECTORY_PATH = "src/main/database/";
    private static final String FILENAME = DIRECTORY_PATH + "clientes.txt";

    // Método para salvar um novo cliente no arquivo TXT
    public static boolean salvarCliente(ClienteModel cliente) {
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
            out.println(formatarClienteParaTexto(cliente)); // Aqui o cliente é formatado como texto e escrito no arquivo
            return true; // Retorna true se o cliente for salvo com sucesso
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Retorna false se ocorrer uma exceção ao escrever no arquivo
        }
    }


    // Método para carregar todos os clientes do arquivo TXT
    public static List<ClienteModel> carregarClientes() {
        List<ClienteModel> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                ClienteModel cliente = parseClienteFromTexto(line);
                if (cliente != null) {
                    clientes.add(cliente);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    // Método auxiliar para formatar um cliente como uma linha de texto
    private static String formatarClienteParaTexto(ClienteModel cliente) {
        return cliente.getId() + ";" +
                cliente.getNome() + ";" +
                cliente.getCpf() + ";" +
                cliente.getRg() + ";" +
                cliente.getDataNascimento() + ";" +
                cliente.getLimiteCred();
    }

    // Método auxiliar para criar um objeto ClienteModel a partir de uma linha de texto
    private static ClienteModel parseClienteFromTexto(String line) {
        String[] parts = line.split(";");
        if (parts.length == 6) {
            long id = Long.parseLong(parts[0]);
            String nome = parts[1];
            String cpf = parts[2];
            int rg = Integer.parseInt(parts[3]);
            LocalDate dataNascimento = LocalDate.parse(parts[4]);
            BigDecimal limiteCred = new BigDecimal(parts[5]);
            return new ClienteModel(id, nome, cpf, rg, dataNascimento, limiteCred);
        }
        return null;
    }
}
