package main;

import dao.CampeonatoDAO;
import dao.EquipeDAO;
import dao.JogadorDAO;
import dao.TecnicoDAO;
import domain.Campeonato;
import domain.Equipe;
import domain.Jogador;
import domain.Tecnico;
import persistence.JpaPersistence;

import java.time.LocalDate;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {


       var campeonato =
               Campeonato.builder().nomeCampeonato("Copa do Brasil")
                       .dataInicio(LocalDate.of(2023, 05, 7))
                       .dataFim(LocalDate.of(2023, 10, 14))
                       .build();
        var campeonatoDAO = new CampeonatoDAO();
        //System.out.println("Salvando campeonato...");
        //campeonatoDAO.saveOrUpdate(campeonato);
        //System.out.println("Operação realizada com sucesso!");

        var tecnico = new Tecnico();
        tecnico.setNome("Guardiola");
        tecnico.setCpf("4567432");
        tecnico.setMatriculaCBF("1515");

       // System.out.println("Salvando tecnico...");
        var tecnicoDAO = new TecnicoDAO();
        //tecnicoDAO.saveOrUpdate(tecnico);
        //System.out.println("Operação realizada com sucesso!");
        var guardiola = tecnicoDAO.findById(Tecnico.class, 1l);
        var jogador1 = new Jogador();
        jogador1.setCpf("1222");
        jogador1.setNome("Pelé");
        jogador1.setPosicao("Atacante");
        jogador1.setTitular(Boolean.TRUE);

        var jogador2 = new Jogador();
        jogador2.setCpf("4565");
        jogador2.setNome("Messi");
        jogador2.setPosicao("Meia");
        jogador2.setTitular(Boolean.FALSE);
        var equipe =
                Equipe.builder().tecnico(guardiola)
                        .id(1l)
                        .nome("Equipe A")
                        .campeonatos(Arrays
                        .asList(campeonatoDAO.campeonatoByName("Paraibano"),
                         campeonatoDAO.campeonatoByName("Copa do Brasil")))
                        .jogadores(Arrays.asList(jogador1,jogador2))
                        .build();
                var equipeDAO = new EquipeDAO();
              //  equipeDAO.saveOrUpdate(equipe);
              var eq = equipeDAO.findById(Equipe.class, 1l);
              var jogadorDAO = new JogadorDAO();
              var pele = jogadorDAO.findById(Jogador.class, 2l);
              var messi = jogadorDAO.findById(Jogador.class, 3l);
              pele.setEquipe(eq);
              messi.setEquipe(eq);
              var jogadores = Arrays.asList(messi, pele);
              jogadores.forEach(j -> {
                  jogadorDAO.saveOrUpdate(j);
              });




        // var c = campeonatoDAO.findById(Campeonato.class, 1l);

       // System.out.println(c);

    }
}
