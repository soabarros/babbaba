package br.com.fiap.jdbc.teste;

import br.com.fiap.jdbc.dao.CandidatoDAO;
import br.com.fiap.jdbc.dao.AreaAtuacaoDAO;
import br.com.fiap.jdbc.model.Candidato;
import br.com.fiap.jdbc.model.AreaAtuacao;
import br.com.fiap.jdbc.model.Genero;

import java.sql.Date;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        CandidatoDAO candidatoDAO = new CandidatoDAO();
        AreaAtuacaoDAO areaAtuacaoDAO = new AreaAtuacaoDAO();

        // Criar uma nova área de atuação para testes
        AreaAtuacao areaAtuacao = new AreaAtuacao(1, "Desenvolvimento de Software");
        areaAtuacaoDAO.inserir(areaAtuacao);
        System.out.println("Área de Atuação inserida com sucesso!");

        // Criar um novo candidato para o teste
        Candidato candidato = new Candidato(
            3, // tempo de experiência
            "Maria Oliveira", // nome
            "11987654321", // telefone
            "maria.oliveira@email.com", // email
            "Avenida Exemplo, 500", // endereço
            "Ciência da Computação", // formação
            Date.valueOf("1992-04-15"), // data de nascimento
            1, // idcandidato
            areaAtuacao.getIdarea(), // idarea
            Genero.feminino // gênero
        );

        // Teste de inserção de candidato
        candidatoDAO.inserir(candidato);
        System.out.println("Candidato inserido com sucesso!");

        // Teste de busca por ID de candidato
        Candidato candidatoBuscado = candidatoDAO.buscarPorId(candidato.getIdcandidato());
        if (candidatoBuscado != null) {
            System.out.println("Candidato encontrado: " + candidatoBuscado.getNome());
        } else {
            System.out.println("Candidato não encontrado.");
        }

        // Teste de atualização do candidato
        candidatoBuscado.setNome("Maria Oliveira Atualizada");
        candidatoDAO.atualizar(candidatoBuscado);
        System.out.println("Candidato atualizado com sucesso!");

        // Verificar atualização
        Candidato candidatoAtualizado = candidatoDAO.buscarPorId(candidatoBuscado.getIdcandidato());
        System.out.println("Nome atualizado do candidato: " + candidatoAtualizado.getNome());

        // Teste para listar todos os candidatos
        List<Candidato> candidatos = candidatoDAO.listarTodos();
        System.out.println("Lista de Candidatos:");
        for (Candidato c : candidatos) {
            System.out.println("ID: " + c.getIdcandidato() + ", Nome: " + c.getNome());
        }

        // Teste de exclusão de candidato
        candidatoDAO.deletar(candidatoAtualizado.getIdcandidato());
        System.out.println("Candidato deletado com sucesso!");

        // Verificar se a exclusão foi bem-sucedida
        Candidato candidatoDeletado = candidatoDAO.buscarPorId(candidatoAtualizado.getIdcandidato());
        if (candidatoDeletado == null) {
            System.out.println("Candidato excluído corretamente.");
        } else {
            System.out.println("Erro ao excluir o candidato.");
        }

        // Teste de exclusão da área de atuação criada
        areaAtuacaoDAO.deletar(areaAtuacao.getIdarea());
        System.out.println("Área de Atuação deletada com sucesso!");
    }
}