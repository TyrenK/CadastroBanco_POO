**Sistema de Cadastro de Contas Bancárias**

*O que é*

- Este é um sistema simples em Java Swing que permite criar, consultar, atualizar e excluir contas bancárias. Cada conta está associada a um cliente, e você pode escolher entre Conta Corrente ou Conta Poupança.

- Os dados ficam salvos apenas enquanto o programa está aberto.

*Como funciona*
*Criar conta*

- Preencha todos os campos: agência, número da conta, nome, endereço, telefone e CPF.

- Escolha o tipo de conta.

- Clique em Criar.

- Se for a primeira conta criada, o botão Consultar será habilitado.

*Consultar conta*

- Digite agência e número da conta.

- Clique em Consultar.

- Se a conta existir, os dados aparecem nos campos.

- Os campos ficam bloqueados até você clicar em Atualizar.

*Atualizar conta*

- Clique em Atualizar para habilitar a edição.

- Altere os dados que quiser (inclusive tipo de conta).

- Clique em Atualizar de novo para salvar as mudanças.

*Excluir conta*

- Clique em Excluir e confirme.

- A conta e o cliente são removidos.

- Se não houver mais contas, o botão Consultar é desativado.

**Observações importantes**

- Todos os campos devem ser preenchidos para criar ou atualizar uma conta.

- Apenas números podem ser digitados nos campos de agência e número da conta.

O tipo da conta só pode ser alterado após clicar em Atualizar.

Os dados não são salvos em arquivos; tudo fica na memória enquanto o programa estiver aberto.
