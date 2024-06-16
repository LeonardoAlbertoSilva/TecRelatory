
package tecrelatory;

import connect.ConnectFactory;
import Dominio.Cidade;
import Dominio.Cliente;
import Dominio.Email;
import Dominio.EmailUsuario;
import Dominio.Endereco;
import Dominio.Estado;
import Dominio.ExecutarServico;
import Dominio.Material;   
import Dominio.Servico;
import Dominio.Telefone;
import Dominio.TelefoneUsuario;
import Dominio.Usuario;
import CRUD.CidadeCrud;
import CRUD.ClienteCrud;
import CRUD.EmailCrud;
import CRUD.EmailUsuarioCrud;
import CRUD.EnderecoCrud;
import CRUD.EstadoCrud;
import CRUD.ExecutarServicoCrud;
import CRUD.MaterialCrud;
import CRUD.ServicoCrud;
import CRUD.TelefoneCrud;
import CRUD.TelefoneUsuarioCrud;
import CRUD.UsuarioCrud;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.List;
import java.util.Scanner;

public class TecRelatory {

    public static void main(String[] args) throws SQLException {
        
        try {
            ConnectFactory a = new ConnectFactory();
            a.getConnection();
            System.out.println("Conexao bem Sucedida");
        } catch (Exception e){
            System.out.println("Erro Conexao");
        }
        
        CidadeCrud cidadeCrud = new CidadeCrud();
        ClienteCrud clienteCrud = new ClienteCrud();
        EmailCrud emailCrud = new EmailCrud();
        EmailUsuarioCrud emailUsuarioCrud = new EmailUsuarioCrud();
        EnderecoCrud enderecoCrud = new EnderecoCrud();
        EstadoCrud estadoCrud = new EstadoCrud();
        ExecutarServicoCrud executarServicoCrud = new ExecutarServicoCrud();
        MaterialCrud materialCrud = new MaterialCrud();
        ServicoCrud servicoCrud = new ServicoCrud();
        TelefoneCrud telefoneCrud = new TelefoneCrud();
        TelefoneUsuarioCrud telefoneUsuarioCrud = new TelefoneUsuarioCrud();
        UsuarioCrud usuarioCrud = new UsuarioCrud();
        
        Scanner scanner = new Scanner(System.in);
        
        int numeroId;

        while (true) {
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Ver Cliente");
            System.out.println("3. Ver Todos os Clientes");
            System.out.println("4. Atualizar Cliente");
            System.out.println("5. Deletar Cliente");
            System.out.println("6. Adicionar Telefone do Cliente");
            System.out.println("7. Ver Telefone do Cliente");
            System.out.println("8. Ver Todos os Telefones dos Clientes");
            System.out.println("9. Atualizar Telefone do Cliente");
            System.out.println("10. Deletar Telefone do Cliente");
            System.out.println("11. Adicionar Email do Cliente");
            System.out.println("12. Ver Email do Cliente");
            System.out.println("13. Ver Todos os Emails do Cliente");
            System.out.println("14. Atualizar Email do Cliente");
            System.out.println("15. Deletar Email do Cliente");
            System.out.println("16. Adicionar Estado");
            System.out.println("17. Ver Estado");
            System.out.println("18. Ver Todos os Estados");
            System.out.println("19. Atualizar Estado");
            System.out.println("20. Deletar Estado");
            System.out.println("21. Adicionar Cidade");
            System.out.println("22. Ver Cidade");
            System.out.println("23. Ver Todas as Cidades");
            System.out.println("24. Atualizar Cidade");
            System.out.println("25. Deletar Cidade");
            System.out.println("26. Adicionar Endereco");
            System.out.println("27. Ver Endereco");
            System.out.println("28. Ver Todos os Enderecos");
            System.out.println("29. Atualizar Endereco");
            System.out.println("30. Deletar Endereco");
            System.out.println("31. Adicionar Material");
            System.out.println("32. Verificar Material");
            System.out.println("33. Verificar Todos os Materiais");
            System.out.println("34. Atualizar Material");
            System.out.println("35. Deletar Material");
            System.out.println("36. Adicionar Telefone do Usuario");
            System.out.println("37. Ver Telefone do Usuario");
            System.out.println("38. Ver Todos os Telefones dos Usuarios");
            System.out.println("39. Atualizar Telefone do Usuario");
            System.out.println("40. Deletar Telefone do Usuario");
            System.out.println("41. Adicionar Email do Usuario");
            System.out.println("42. Ver Email do Usuario");
            System.out.println("43. Ver Todos os Emails dos Usuarios");
            System.out.println("44. Atualizar Email do Usuario");
            System.out.println("45. Deletar Email do Usuario");
            System.out.println("46. Adicionar Novo Usuario");
            System.out.println("47. Ver Usuario");
            System.out.println("48. Ver Todos os Usuarios");
            System.out.println("49. Atualizar Usuario");
            System.out.println("50. Deletar Usuario");
            System.out.println("51. Adicionar Novo Servico");
            System.out.println("52. Listar Servico");
            System.out.println("53. Listar Todos os Servicos");
            System.out.println("54. Atualizar Servico");
            System.out.println("55. Deletar Servico");
            System.out.println("56. Adicionar Nova Execucao de Servico");
            System.out.println("57. Listar Servico em Execucao");
            System.out.println("58. Listar Todos os Servicos em Execucao");
            System.out.println("59. Atualizar Servico em Execucao");
            System.out.println("60. Deletar Servico em Execucao");
            System.out.println("61. Sair");
            System.out.print("Escolha uma opcao: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consome a nova linha

            switch (choice) {
                case 1:
                    // Adicionar Cliente
                    Cliente cliente = new Cliente();
                    System.out.print("Nome: ");
                    cliente.setNome(scanner.nextLine());
                    System.out.print("CPF: ");
                    cliente.setCpf(scanner.nextLine());
                    System.out.print("ID Endereço: ");
                    cliente.setIdEndereco(scanner.nextInt());
                    System.out.print("ID Telefone: ");
                    cliente.setIdTelefone(scanner.nextInt());
                    System.out.print("ID Email: ");
                    cliente.setIdEmail(scanner.nextInt());
                    clienteCrud.addCliente(cliente);
                    break;
                case 2:
                    // Ver Cliente
                    System.out.print("ID do Cliente: ");
                    Cliente clienteEncontrado = clienteCrud.getCliente(scanner.nextInt());
                    if (clienteEncontrado != null) {
                        System.out.println("ID: " + clienteEncontrado.getId());
                        System.out.println("Nome: " + clienteEncontrado.getNome());
                        System.out.println("CPF: " + clienteEncontrado.getCpf());
                        System.out.println("ID Endereço: " + clienteEncontrado.getIdEndereco());
                        System.out.println("ID Telefone: " + clienteEncontrado.getIdTelefone());
                        System.out.println("ID Email: " + clienteEncontrado.getIdEmail());
                    } else {
                        System.out.println("Cliente nao encontrado.");
                    }
                    break;
                case 3:
                    // Ver Todos os Clientes
                    List<Cliente> clientes = clienteCrud.getAllClientes();
                    for (Cliente c : clientes) {
                        System.out.println("ID: " + c.getId() + ", Nome: " + c.getNome() + ", CPF: " + c.getCpf() + ", ID Endereço: " + c.getIdEndereco() + ", ID Telefone: " + c.getIdTelefone() + ", ID Email: " + c.getIdEmail());
                    }
                    break;
                case 4:
                    // Atualizar Cliente
                    cliente = new Cliente();
                    System.out.print("ID: ");
                    cliente.setId(scanner.nextInt());
                    scanner.nextLine(); // consome a nova linha
                    System.out.print("Nome: ");
                    cliente.setNome(scanner.nextLine());
                    System.out.print("CPF: ");
                    cliente.setCpf(scanner.nextLine());
                    System.out.print("ID Endereço: ");
                    cliente.setIdEndereco(scanner.nextInt());
                    System.out.print("ID Telefone: ");
                    cliente.setIdTelefone(scanner.nextInt());
                    System.out.print("ID Email: ");
                    cliente.setIdEmail(scanner.nextInt());
                    clienteCrud.updateCliente(cliente);
                    break;
                case 5:
                    // Deletar Cliente
                    System.out.print("ID do Cliente: ");
                    clienteCrud.deleteCliente(scanner.nextInt());
                    break;
                case 6:
                    // Adicionar Telefone
                    Telefone telefone = new Telefone();
                    System.out.print("Numero: ");
                    telefone.setNumero(scanner.nextLine());
                    telefoneCrud.addTelefone(telefone);
                    break;
                case 7:
                    // Ver Telefone
                    System.out.print("ID do Telefone: ");
                    Telefone telefoneEncontrado = telefoneCrud.getTelefone(scanner.nextInt());
                    if (telefoneEncontrado != null) {
                        System.out.println("ID: " + telefoneEncontrado.getId());
                        System.out.println("Numero: " + telefoneEncontrado.getNumero());
                    } else {
                        System.out.println("Telefone não encontrado.");
                    }
                    break;
                case 8:
                    // Ver Todos os Telefones
                    List<Telefone> telefones = telefoneCrud.getAllTelefones();
                    for (Telefone t : telefones) {
                        System.out.println("ID: " + t.getId() + ", Numero: " + t.getNumero());
                    }
                    break;
                case 9:
                    // Atualizar Telefone
                    telefone = new Telefone();
                    System.out.print("ID: ");
                    telefone.setId(scanner.nextInt());
                    scanner.nextLine(); // consome a nova linha
                    System.out.print("Numero: ");
                    telefone.setNumero(scanner.nextLine());
                    telefoneCrud.updateTelefone(telefone);
                    break;
                case 10:
                    // Deletar Telefone
                    System.out.print("ID do Telefone: ");
                    telefoneCrud.deleteTelefone(scanner.nextInt());
                    break;
                case 11:
                    // Adicionar Email
                    Email email = new Email();
                    System.out.print("Email: ");
                    email.setEmail(scanner.nextLine());
                    emailCrud.addEmail(email);
                    break;
                case 12:
                    // Ver Email
                    System.out.print("ID do Email: ");
                    Email emailEncontrado = emailCrud.getEmail(scanner.nextInt());
                    if (emailEncontrado != null) {
                        System.out.println("ID: " + emailEncontrado.getId());
                        System.out.println("Email: " + emailEncontrado.getEmail());
                    } else {
                        System.out.println("Email nao encontrado.");
                    }
                    break;
                case 13:
                    // Ver Todos os Emails
                    List<Email> emails = emailCrud.getAllEmails();
                    for (Email e : emails) {
                        System.out.println("ID: " + e.getId() + ", Email: " + e.getEmail());
                    }
                    break;
                case 14:
                    // Atualizar Email
                    email = new Email();
                    System.out.print("ID: ");
                    email.setId(scanner.nextInt());
                    scanner.nextLine(); // consome a nova linha
                    System.out.print("Email: ");
                    email.setEmail(scanner.nextLine());
                    emailCrud.updateEmail(email);
                    break;
                case 15:
                    // Deletar Email
                    System.out.print("ID do Email: ");
                    emailCrud.deleteEmail(scanner.nextInt());
                    break;
                case 16:
                    // Adicionar Estado
                    Estado estado = new Estado();
                    System.out.print("Nome: ");
                    estado.setNome(scanner.nextLine());
                    System.out.print("UF: ");
                    estado.setUf(scanner.nextLine());
                    estadoCrud.addEstado(estado);
                    break;
                case 17:
                    // Ver Estado
                    System.out.print("ID do Estado: ");
                    Estado estadoEncontrado = estadoCrud.getEstado(scanner.nextInt());
                    if (estadoEncontrado != null) {
                        System.out.println("ID: " + estadoEncontrado.getId());
                        System.out.println("Nome: " + estadoEncontrado.getNome());
                        System.out.println("UF: " + estadoEncontrado.getUf());
                    } else {
                        System.out.println("Estado nao encontrado.");
                    }
                    break;
                case 18:
                    // Ver Todos os Estados
                    List<Estado> estados = estadoCrud.getAllEstados();
                    for (Estado es : estados) {
                        System.out.println("ID: " + es.getId() + ", Nome: " + es.getNome() + ", UF: " + es.getUf());
                    }
                    break;
                case 19:
                    // Atualizar Estado
                    estado = new Estado();
                    System.out.print("ID: ");
                    estado.setId(scanner.nextInt());
                    scanner.nextLine(); // consome a nova linha
                    System.out.print("Nome: ");
                    estado.setNome(scanner.nextLine());
                    System.out.print("UF: ");
                    estado.setUf(scanner.nextLine());
                    estadoCrud.updateEstado(estado);
                    break;
                case 20:
                    // Deletar Estado
                    System.out.print("ID do Estado: ");
                    estadoCrud.deleteEstado(scanner.nextInt());
                    break;
                case 21:
                    // Adicionar Cidade
                    Cidade cidade = new Cidade();
                    System.out.print("ID Estado: ");
                    cidade.setIdEstado(scanner.nextInt());
                    scanner.nextLine(); // consome a nova linha
                    System.out.print("Nome: ");
                    cidade.setNome(scanner.nextLine());
                    cidadeCrud.addCidade(cidade);
                    break;
                case 22:
                    // Ver Cidade
                    System.out.print("ID da Cidade: ");
                    Cidade cidadeEncontrada = cidadeCrud.getCidade(scanner.nextInt());
                    if (cidadeEncontrada != null) {
                        System.out.println("ID: " + cidadeEncontrada.getId());
                        System.out.println("ID Estado: " + cidadeEncontrada.getIdEstado());
                        System.out.println("Nome: " + cidadeEncontrada.getNome());
                    } else {
                        System.out.println("Cidade nao encontrada.");
                    }
                    break;
                case 23:
                    // Ver Todas as Cidades
                    List<Cidade> cidades = cidadeCrud.getAllCidades();
                    for (Cidade c : cidades) {
                        System.out.println("ID: " + c.getId() + ", ID Estado: " + c.getIdEstado() + ", Nome: " + c.getNome());
                    }
                    break;
                case 24:
                    // Atualizar Cidade
                    cidade = new Cidade();
                    System.out.print("ID: ");
                    cidade.setId(scanner.nextInt());
                    System.out.print("ID Estado: ");
                    cidade.setIdEstado(scanner.nextInt());
                    scanner.nextLine(); // consome a nova linha
                    System.out.print("Nome: ");
                    cidade.setNome(scanner.nextLine());
                    cidadeCrud.updateCidade(cidade);
                    break;
                case 25:
                    // Deletar Cidade
                    System.out.print("ID da Cidade: ");
                    cidadeCrud.deleteCidade(scanner.nextInt());
                    break;
                case 26:
                    // Adicionar Endereco
                    Endereco endereco = new Endereco();
                    System.out.print("ID Cidade: ");
                    endereco.setIdCidade(scanner.nextInt());
                    scanner.nextLine(); // consome a nova linha
                    System.out.print("Rua: ");
                    endereco.setRua(scanner.nextLine());
                    System.out.print("Numero: ");
                    endereco.setNumero(scanner.nextLine());
                    enderecoCrud.addEndereco(endereco);
                    break;
                case 27:
                    // Ver Endereco
                    System.out.print("ID do Endereco: ");
                    Endereco enderecoEncontrado = enderecoCrud.getEndereco(scanner.nextInt());
                    if (enderecoEncontrado != null) {
                        System.out.println("ID: " + enderecoEncontrado.getId());
                        System.out.println("ID Cidade: " + enderecoEncontrado.getIdCidade());
                        System.out.println("Rua: " + enderecoEncontrado.getRua());
                        System.out.println("Numero: " + enderecoEncontrado.getNumero());
                    } else {
                        System.out.println("Endereco nao encontrado.");
                    }
                    break;
                case 28:
                    // Ver Todos os Enderecos
                    List<Endereco> enderecos = enderecoCrud.getAllEnderecos();
                    for (Endereco e : enderecos) {
                        System.out.println("ID: " + e.getId() + ", ID Cidade: " + e.getIdCidade() + ", Rua: " + e.getRua() + ", Numero: " + e.getNumero());
                    }
                    break;
                case 29:
                    // Atualizar Endereco
                    endereco = new Endereco();
                    System.out.print("ID: ");
                    endereco.setId(scanner.nextInt());
                    System.out.print("ID Cidade: ");
                    endereco.setIdCidade(scanner.nextInt());
                    scanner.nextLine(); // consome a nova linha
                    System.out.print("Rua: ");
                    endereco.setRua(scanner.nextLine());
                    System.out.print("Numero: ");
                    endereco.setNumero(scanner.nextLine());
                    enderecoCrud.updateEndereco(endereco);
                    break;
                case 30:
                    // Deletar Endereco
                    System.out.print("ID do Endereco: ");
                    enderecoCrud.deleteEndereco(scanner.nextInt());
                    break;
                case 31:
                    // Adicionar Material
                    Material newMaterial = new Material();
                    System.out.print("Descricao do Material: ");
                    newMaterial.setDescricao(scanner.nextLine());
                    System.out.print("Quantidade do Material: ");
                    newMaterial.setQuantidade(scanner.nextInt());
                    System.out.print("Valor do Material: ");
                    newMaterial.setValor(scanner.nextInt());
                    materialCrud.create(newMaterial);
                    System.out.println("Material criado!");
                    break;
                case 32:
                    // Verificar Material
                    System.out.print("ID do Material: ");
                    numeroId = scanner.nextInt();
                    Material material = materialCrud.read(numeroId);
                    if (material != null) {
                        System.out.println("Material encontrado: " + material.getDescricao() + " - Qtd: " + material.getQuantidade() + " - V: " + material.getValor());
                    } else {
                        System.out.println("Material nao encontrado.");
                    }
                    break;
                case 33:
                    // Verificar todos os Materiais
                    List<Material> materials = materialCrud.readAll();
                    for (Material m : materials) {
                        System.out.println(m.getDescricao() + " - Qtd: " + m.getQuantidade() + " - V: " + m.getValor());
                    }
                    break;
                case 34:
                    // Atualizar Material
                    Material updatedMaterial = new Material();
                    System.out.print("ID do Material a ser Atualizado: ");
                    int id = scanner.nextInt();
                    updatedMaterial.setId(id);
                    System.out.print("Nova descricao: ");
                    scanner.nextLine(); // Quebra de linha após nextInt()
                    String novaDescricao = scanner.nextLine();
                    updatedMaterial.setDescricao(novaDescricao);
                    System.out.print("Quantidade: ");
                    double qtd = scanner.nextInt();
                    updatedMaterial.setQuantidade(qtd);
                    System.out.print("Valor: ");
                    double valor = scanner.nextInt();
                    updatedMaterial.setValor(valor);
                    materialCrud.update(updatedMaterial);
                    System.out.println("Material atualizado!");
                    break;
                case 35:
                    // Deletar Material
                    System.out.print("ID do Material a ser Deletado: ");
                    numeroId = scanner.nextInt();
                    materialCrud.delete(numeroId);
                    System.out.println("Material deletado!");
                    break;
                case 36:
                    // Adicionar Telefone
                    TelefoneUsuario telefoneUsuario = new TelefoneUsuario();
                    System.out.print("Numero: ");
                    telefoneUsuario.setNumero(scanner.nextLine());
                    telefoneUsuarioCrud.addTelefone(telefoneUsuario);
                    break;
                case 37:
                    // Ver Telefone
                    System.out.print("ID do Telefone: ");
                    TelefoneUsuario telefoneUsuarioEncontrado = telefoneUsuarioCrud.getTelefone(scanner.nextInt());
                    if (telefoneUsuarioEncontrado != null) {
                        System.out.println("ID: " + telefoneUsuarioEncontrado.getId());
                        System.out.println("Numero: " + telefoneUsuarioEncontrado.getNumero());
                    } else {
                        System.out.println("Telefone nao encontrado.");
                    }
                    break;
                case 38:
                    // Ver Todos os Telefones
                    List<TelefoneUsuario> telefonesUsuarios = telefoneUsuarioCrud.getAllTelefones();
                    for (TelefoneUsuario t : telefonesUsuarios) {
                        System.out.println("ID: " + t.getId() + ", Numero: " + t.getNumero());
                    }
                    break;
                case 39:
                    // Atualizar Telefone
                    telefoneUsuario = new TelefoneUsuario();
                    System.out.print("ID: ");
                    telefoneUsuario.setId(scanner.nextInt());
                    scanner.nextLine(); // consome a nova linha
                    System.out.print("Numero: ");
                    telefoneUsuario.setNumero(scanner.nextLine());
                    telefoneUsuarioCrud.updateTelefone(telefoneUsuario);
                    break;
                case 40:
                    // Deletar Telefone
                    System.out.print("ID do Telefone: ");
                    telefoneUsuarioCrud.deleteTelefone(scanner.nextInt());
                    break;
                case 41:
                    // Adicionar Email
                    EmailUsuario emailUsuario = new EmailUsuario();
                    System.out.print("Email: ");
                    emailUsuario.setEmail(scanner.nextLine());
                    emailUsuarioCrud.addEmail(emailUsuario);
                    break;
                case 42:
                    // Ver Email
                    System.out.print("ID do Email: ");
                    EmailUsuario emailUsuarioEncontrado = emailUsuarioCrud.getEmail(scanner.nextInt());
                    if (emailUsuarioEncontrado != null) {
                        System.out.println("ID: " + emailUsuarioEncontrado.getId());
                        System.out.println("Email: " + emailUsuarioEncontrado.getEmail());
                    } else {
                        System.out.println("Email nao encontrado.");
                    }
                    break;
                case 43:
                    // Ver Todos os Emails
                    List<EmailUsuario> emailsUsuarios = emailUsuarioCrud.getAllEmails();
                    for (EmailUsuario e : emailsUsuarios) {
                        System.out.println("ID: " + e.getId() + ", Email: " + e.getEmail());
                    }
                    break;
                case 44:
                    // Atualizar Email
                    emailUsuario = new EmailUsuario();
                    System.out.print("ID: ");
                    emailUsuario.setId(scanner.nextInt());
                    scanner.nextLine(); // consome a nova linha
                    System.out.print("Email: ");
                    emailUsuario.setEmail(scanner.nextLine());
                    emailUsuarioCrud.updateEmail(emailUsuario);
                    break;
                case 45:
                    // Deletar Email
                    System.out.print("ID do Email: ");
                    emailUsuarioCrud.deleteEmail(scanner.nextInt());
                    break;
                case 46:
                    // Adicionar Usuario
                    Usuario usuario = new Usuario();
                    System.out.print("Nome: ");
                    usuario.setNome(scanner.nextLine());
                    System.out.print("CPF: ");
                    usuario.setCpf(scanner.nextLine());
                    System.out.print("ID Telefone: ");
                    usuario.setIdTelefone(scanner.nextInt());
                    System.out.print("ID Email: ");
                    usuario.setIdEmail(scanner.nextInt());
                    scanner.nextLine(); // Consumir a nova linha pendente após nextInt()
                    System.out.print("Login: ");
                    usuario.setLogin(scanner.nextLine());
                    System.out.print("Senha: ");
                    usuario.setSenha(scanner.nextLine());
                    usuarioCrud.addUsuario(usuario);
                    break;
                case 47:
                    // Ver Usuario
                    System.out.print("ID do Usuario: ");
                    Usuario usuarioEncontrado = usuarioCrud.getUsuario(scanner.nextInt());
                    if (usuarioEncontrado != null) {
                        System.out.println("ID: " + usuarioEncontrado.getId());
                        System.out.println("Nome: " + usuarioEncontrado.getNome());
                        System.out.println("CPF: " + usuarioEncontrado.getCpf());
                        System.out.println("ID Telefone: " + usuarioEncontrado.getIdTelefone());
                        System.out.println("ID Email: " + usuarioEncontrado.getIdEmail());
                        System.out.println("Login: " + usuarioEncontrado.getLogin());
                        System.out.println("Senha: " + usuarioEncontrado.getSenha());
                    } else {
                        System.out.println("Usuario nao encontrado.");
                    }
                    break;
                case 48:
                    // Ver Todos os Usuarios
                    List<Usuario> usuarios = usuarioCrud.getAllUsuarios();
                    for (Usuario u : usuarios) {
                        System.out.println("ID: " + u.getId() + ", Nome: " + u.getNome() + ", CPF: " + u.getCpf() + ", ID Telefone: " + u.getIdTelefone() + ", ID Email: " + u.getIdEmail() + ", Login: " + u.getLogin() + ", Senha: " + u.getSenha());
                    }
                    break;
                case 49:
                    // Atualizar Usuario
                    usuario = new Usuario();
                    System.out.print("ID: ");
                    usuario.setId(scanner.nextInt());
                    System.out.print("Nome: ");
                    scanner.nextLine(); // consome a nova linha
                    usuario.setNome(scanner.nextLine());
                    System.out.print("CPF: ");
                    usuario.setCpf(scanner.nextLine());
                    System.out.print("ID Telefone: ");
                    usuario.setIdTelefone(scanner.nextInt());
                    System.out.print("ID Email: ");
                    usuario.setIdEmail(scanner.nextInt());
                    scanner.nextLine(); // consome a nova linha
                    System.out.print("Login: ");
                    usuario.setLogin(scanner.nextLine());
                    System.out.print("Senha: ");
                    usuario.setSenha(scanner.nextLine());
                    usuarioCrud.updateUsuario(usuario);
                    break;
                case 50:
                    // Deletar Usuario
                    System.out.print("ID do Usuario: ");
                    usuarioCrud.deleteUsuario(scanner.nextInt());
                    break; 
                case 51:
                    // Adicionar Servico
                    Servico servico = new Servico();
                    System.out.print("ID do Cliente: ");
                    servico.setIdCliente(scanner.nextInt());
                    System.out.print("Data de Inicio (AAAA-MM-DD): ");
                    servico.setDataInicio(LocalDate.parse(scanner.next()));
                    scanner.nextLine(); // Consumir nova linha
                    System.out.print("Descricao do Problema: ");
                    servico.setDescricaoProblema(scanner.nextLine());
                    System.out.print("Data de Fim (AAAA-MM-DD) [opcional]: ");
                    String dataFim = scanner.nextLine();
                    if (!dataFim.isEmpty()) {
                        servico.setDataFim(LocalDate.parse(dataFim));
                    }
                    System.out.print("Descricao da Solucao: ");
                    servico.setDescricaoSolucao(scanner.nextLine());
                    System.out.print("ID do Material: ");
                    servico.setIdMaterial(scanner.nextInt());
                    scanner.nextLine(); // Pular Linha
                    servicoCrud.addServico(servico);
                    break;
                case 52:
                    // Ver Servico
                    System.out.print("ID do Servico: ");
                    Servico servicoEncontrado = servicoCrud.getServico(scanner.nextInt());
                    if (servicoEncontrado != null) {
                        System.out.println("ID: " + servicoEncontrado.getId());
                        System.out.println("ID Cliente: " + servicoEncontrado.getIdCliente());
                        System.out.println("Data Inicio: " + servicoEncontrado.getDataInicio());
                        System.out.println("Problema: " + servicoEncontrado.getDescricaoProblema());
                        //System.out.println("Imagem Problema: " + servicoEncontrado.getImagemProblema());
                        System.out.println("Data Fim: " + servicoEncontrado.getDataFim());
                        System.out.println("Solucao: " + servicoEncontrado.getDescricaoSolucao());
                        //System.out.println("Imagem Solucao: " + servicoEncontrado.getImagemSolucao());
                        System.out.println("Material: " + servicoEncontrado.getIdMaterial());
                    } else {
                        System.out.println("Servico nao encontrado.");
                    }
                    break;
                case 53:
                    // Ver Todos os Servico
                    List<Servico> servicos = servicoCrud.getAllServicos();
                    for (Servico s : servicos) {
                        System.out.println(s);
                    }
                    break;
                case 54:
                    // Atualizar Servico
                    System.out.print("ID do Servico: ");
                    Servico servicoToUpdate = servicoCrud.getServico(scanner.nextInt());
                    scanner.nextLine(); // Consumir nova linha
                    if (servicoToUpdate != null) {
                        System.out.print("Novo ID do Cliente: ");
                        servicoToUpdate.setIdCliente(scanner.nextInt());
                        System.out.print("Nova Data de Início (AAAA-MM-DD): ");
                        servicoToUpdate.setDataInicio(LocalDate.parse(scanner.next()));
                        scanner.nextLine(); // Consumir nova linha
                        System.out.print("Nova Descricao do Problema: ");
                        servicoToUpdate.setDescricaoProblema(scanner.nextLine());
                        System.out.print("Nova Data de Fim (AAAA-MM-DD) [opcional]: ");
                        String novaDataFim = scanner.nextLine();
                        if (!novaDataFim.isEmpty()) {
                            servicoToUpdate.setDataFim(LocalDate.parse(novaDataFim));
                        }
                        System.out.print("Nova Descrição da Solucao: ");
                        servicoToUpdate.setDescricaoSolucao(scanner.nextLine());
                        System.out.print("Novo ID do Material: ");
                        servicoToUpdate.setIdMaterial(scanner.nextInt());
                        servicoCrud.updateServico(servicoToUpdate);
                    } else {
                        System.out.println("Servico nao encontrado.");
                    }
                    break;
                case 55:
                    // Deletar Servico
                    System.out.print("ID do Servico: ");
                    servicoCrud.deleteServico(scanner.nextInt());
                    break;
                case 56:
                    // Adicionar ExecutarServico
                    ExecutarServico executarServico = new ExecutarServico();
                    System.out.print("ID do Usuario: ");
                    executarServico.setIdUsuario(scanner.nextInt());
                    System.out.print("ID do Servico: ");
                    executarServico.setIdServico(scanner.nextInt());
                    scanner.nextLine(); // Consumir nova linha
                    System.out.print("Status: ");
                    executarServico.setStatus(scanner.nextLine());
                    executarServicoCrud.addExecutarServico(executarServico);
                    break;
                case 57:
                    // Ver ExecutarServico
                    System.out.print("ID do Usuario: ");
                    ExecutarServico executarServicoEncontrado = executarServicoCrud.getExecutarServico(scanner.nextInt());
                    if (executarServicoEncontrado != null) {
                        System.out.println("ID: " + executarServicoEncontrado.getId());
                        System.out.println("ID Usuario: " + executarServicoEncontrado.getIdUsuario());
                        System.out.println("ID Servico: " + executarServicoEncontrado.getIdServico());
                        System.out.println("Status: " + executarServicoEncontrado.getStatus());
                    } else {
                        System.out.println("Servico Executado Nao Encontrado.");
                    }
                    break;
                case 58:
                    // Ver Todos os ExecutarServico
                    List<ExecutarServico> executarServicos = executarServicoCrud.getAllExecutarServicos();
                    for (ExecutarServico es : executarServicos) {
                        System.out.println(es);
                    }
                    break;
                case 59:
                    // Atualizar ExecutarServico
                    System.out.print("ID do ExecutarServico: ");
                    ExecutarServico executarServicoToUpdate = executarServicoCrud.getExecutarServico(scanner.nextInt());
                    scanner.nextLine(); // Consumir nova linha
                    if (executarServicoToUpdate != null) {
                        System.out.print("Novo ID do Usuario: ");
                        executarServicoToUpdate.setIdUsuario(scanner.nextInt());
                        System.out.print("Novo ID do Servico: ");
                        executarServicoToUpdate.setIdServico(scanner.nextInt());
                        scanner.nextLine(); // Consumir nova linha
                        System.out.print("Novo Status: ");
                        executarServicoToUpdate.setStatus(scanner.nextLine());
                        executarServicoCrud.updateExecutarServico(executarServicoToUpdate);
                    } else {
                        System.out.println("ExecutarServico nao encontrado.");
                    }
                    break;
                case 60:
                    // Deletar ExecutarServico
                    System.out.print("ID do ExecutarServico: ");
                    executarServicoCrud.deleteExecutarServico(scanner.nextInt());
                    break;
                case 61:
                    // Sair
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção invalida. Tente novamente.");
                    break;
            }
        }
       
    }
}
