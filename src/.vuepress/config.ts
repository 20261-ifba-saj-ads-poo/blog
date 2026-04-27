import { defineUserConfig } from "vuepress";
import umlPlugin from 'markdown-it-plantuml';
import container from 'markdown-it-container';
import table_captions from 'markdown-it-table-captions'
import theme from "./theme.js";

export default defineUserConfig({
  base: "/blog/",

  lang: "pt-BR",
  title: "2026.1 ADS POO",
  description: "Material das Aulas",

  extendsMarkdown: (md) => {
    md.use(umlPlugin, {
      openMarker: '```plantuml',
      closeMarker: '```',
      //server: 'https://kroki.io/plantuml/'
    })
    md.use(table_captions)
    md.use(container, 'figure', {
      render: (tokens, idx) => {
        // Procura o texto da legenda (ex: ::: figure Minha Legenda)
        const m = tokens[idx].info.trim().match(/^figure\s*(.*)$/);

        if (tokens[idx].nesting === 1) {
          // Abre apenas o <figure> na parte de cima
          return '<figure>\n';
        } else {
          // No fecho (nesting === -1), recuperamos o texto e fechamos a tag
          // Nota: Precisamos de aceder ao token de abertura para ler o texto original
          const openToken = tokens.slice(0, idx).reverse().find(t => t.type === 'container_figure_open');
          const captionText = openToken.info.trim().match(/^figure\s*(.*)$/)?.[1];

          const figcaption = captionText
            ? `<figcaption>${md.utils.escapeHtml(captionText)}</figcaption>`
            : '';

          return `${figcaption}\n</figure>\n`;
        }
      }
    })
  },

  theme,

  // Enable it with pwa
  shouldPrefetch: true,
});
