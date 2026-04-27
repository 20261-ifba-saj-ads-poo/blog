import { navbar } from "vuepress-theme-hope";

export default navbar([
  "/",
  {
    text: "Aulas",
    icon: "edit",
    link: "/category/aula/",
  },
  {
    text: "Exercícios",
    icon: "dumbbell",
    link: "/category/exercicio/",
  },
  {
    text: "Trabalho",
    icon: "code-pull-request",
    link: "/category/trabalho/",
  },
  {
    text: "Para Entrega",
    icon: "paper-plane",
    link: "/category/entrega/",
  },
  {
    text: "Categoria",
    icon: "list",
    link: "/category/",
  },
  {
    text: "Tag",
    icon: "tag",
    link: "/tag/",
  },
  {
    text: "Timeline",
    icon: "clock",
    link: "/timeline/",
  },
  {
    text: "Imprimir",
    icon: "print",
    link: "/posts/print.md"
  }
]);
