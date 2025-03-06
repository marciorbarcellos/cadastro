package br.com.primeiroprojeto.pessoa.controller;

import br.com.primeiroprojeto.pessoa.model.Pessoa;
import br.com.primeiroprojeto.pessoa.repository.PessoaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/")
public class PessoaController {

    @GetMapping
    public String listarPessoas(Model model) {
        model.addAttribute("lista", PessoaRepository.getListaPessoa());
        return "pessoa/listar-pessoa";
    }

    @GetMapping("/tela-cadastro-pessoa")
    public String telaCadastroPessoa(Pessoa pessoa, Model model) {

        return "pessoa/tela-cadastro-pessoa";
    }


    @PostMapping("/cadastro-pessoa")
    public String cadastrar(Pessoa pessoa) {
        PessoaRepository.addPessoa(pessoa);
        return "redirect:/";
    }

    @GetMapping("/tela-consulta-pessoa/{id}")
    public String telaDeConsultaPessoa(@PathVariable("id") String id, Model model) {
        Pessoa pessoa = PessoaRepository.getPessoa(UUID.fromString(id));
        model.addAttribute("pessoa", pessoa);
        return "pessoa/tela-consulta-pessoa";
    }

    @GetMapping("/tela-alteracao-pessoa/{id}")
    public String telaAlteracaoPessoa(@PathVariable("id") String id, Model model) {
        Pessoa pessoa = PessoaRepository.getPessoa(UUID.fromString(id));
        model.addAttribute("pessoa", pessoa);
        return "pessoa/tela-alteracao-pessoa";
    }


    @PostMapping("/atualiza-pessoa")
    public String atualizaPessoa(Pessoa pessoa) {
        PessoaRepository.atualizaPessoa(pessoa);
        return "redirect:/";
    }

    @GetMapping("/tela-confirmacao-exclusao-pessoa/{id}")
    public String telaConfirmacaoExclusaoPessoa(@PathVariable("id") String id, Model model) {
        Pessoa pessoa = PessoaRepository.getPessoa(UUID.fromString(id));
        model.addAttribute("pessoa", pessoa);
        return "pessoa/tela-confirmacao-exclusao-pessoa";
    }

    @PostMapping("/deletar-pessoa/{id}")
    public String deletaPessoa(@PathVariable("id") String idPessoa) {
        Pessoa pessoa = PessoaRepository.getPessoa(UUID.fromString(idPessoa));
        PessoaRepository.deletePessoa(pessoa);
        return "redirect:/";
    }


}
