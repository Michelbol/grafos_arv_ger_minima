#Trabalho para Disciplica Algoritmos em Grafos

- Aplicar o conceito de Arvore Geradora Mínima na solução de um problema prático.
- Desenvolver 3 casos de teste distintos (em quantidade de pontos e número de agrupamentos) para testar seu código.
- O programa deverá ler inicialmente dois inteiros: n (o número de vértices) e k (o número de agrupamentos).
	Em seguida, dever˜ao ser lidas n linhas, cada uma referente a um ponto no plano, contendo as coordenadas x e y do ponto.
	Os pontos estar˜ao implicitamente numerados de 1 a n. Como saída, o programa deve imprimir k linhas, cada uma contendo os
	pontos que pertencem ao agrupamento em ordem crescente.

## Descrição do Problema de k-agrupamento (k-clustering)

Dado um conjunto S = {p1, p2, . . . , pn} de objetos, particione-os em k grupos n˜ao vazios, tais que objetos em
grupos distintos est˜ao o mais longe possível. Para medir o grau de separação entre dois objetos, consideramos
uma funçao distância que especifica um valor numérico representando o qu˜ao próximo um objeto está de outro.
Esta função distância respeita as seguintes propriedades:
• d(pi, pj ) = 0 ⇐⇒ pi = pj (identidade dos indicerníveis);
• d(pi, pj ) ≥ 0 (n˜ao negatividade);
• d(pi, pj ) = d(pj , pi) (simetria).
O espaçamento é a menor distância entre quaisquer pares de pontos pertencentes a grupos diferentes.
Assim, dado um inteiro k, o objetivo é encontrar um k-agrupamento de espaçamento máximo.

## Exemplo de entrada e Saída
| Entrada | Saída                   |
|---------|-------------------------|
|17 4     |1 3 4                    |
|0 0      |2                        |
|0 3      |5 6 7 8                  |
|2 0      |9 10 11 12 13 14 15 16 17|
|1 1      |                         |
|5 3      |                         |
|5 4      |                         |
|7 3      |                         |
|7 4      |                         |
|10 0     |                         |
|10 1     |                         |
|10 2     |                         |
|11 0     |                         |
|11 1     |                         |
|11 2     |                         |
|12 0     |                         |
|12 1     |                         |
|12 2     |                         |
