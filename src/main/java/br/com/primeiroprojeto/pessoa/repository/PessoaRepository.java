package br.com.primeiroprojeto.pessoa.repository;


import br.com.primeiroprojeto.pessoa.model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class PessoaRepository {
    private static List<Pessoa> listaPessoa = new ArrayList<>();

    public static List<Pessoa> getListaPessoa() {
        return listaPessoa;
    }

    public static Pessoa getPessoa(UUID id) {
        return getListaPessoa()
                .stream()
                .filter(pessoa -> Objects.equals(pessoa.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public static void atualizaPessoa(Pessoa pessoa) {
        Pessoa pessoaNoRepositorio = getPessoa(pessoa.getId());
        pessoaNoRepositorio.setEmail(pessoa.getEmail());
        pessoaNoRepositorio.setEndereco(pessoa.getEndereco());
        pessoaNoRepositorio.setNome(pessoa.getNome());
        pessoaNoRepositorio.setDataNascimento(pessoa.getDataNascimento());
    }

    public static void addPessoa(Pessoa pessoa) {
        pessoa.setId(UUID.randomUUID());
        getListaPessoa().add(pessoa);
    }

    public static void deletePessoa(Pessoa pessoa) {
        listaPessoa = getListaPessoa()
                .stream()
                .filter(pessoaNoRepository -> !Objects.equals(pessoaNoRepository.getId(), pessoa.getId()))
                .collect(Collectors.toList());
    }
}
