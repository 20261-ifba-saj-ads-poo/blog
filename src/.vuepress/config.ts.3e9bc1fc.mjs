// src/.vuepress/config.ts
import { defineUserConfig } from "vuepress";
import umlPlugin from "markdown-it-plantuml";
import container from "markdown-it-container";
import table_captions from "markdown-it-table-captions";

// src/.vuepress/theme.ts
import { hopeTheme } from "vuepress-theme-hope";

// src/.vuepress/navbar.ts
import { navbar } from "vuepress-theme-hope";
var navbar_default = navbar([
  "/",
  {
    text: "Aulas",
    icon: "edit",
    link: "/category/aula/"
  },
  {
    text: "Exerc\xEDcios",
    icon: "dumbbell",
    link: "/category/exercicio/"
  },
  {
    text: "Trabalho",
    icon: "code-pull-request",
    link: "/category/trabalho/"
  },
  {
    text: "Para Entrega",
    icon: "paper-plane",
    link: "/category/entrega/"
  },
  {
    text: "Categoria",
    icon: "list",
    link: "/category/"
  },
  {
    text: "Tag",
    icon: "tag",
    link: "/tag/"
  },
  {
    text: "Timeline",
    icon: "clock",
    link: "/timeline/"
  },
  {
    text: "Imprimir",
    icon: "print",
    link: "/posts/print.md"
  }
]);

// src/.vuepress/sidebar.ts
import { sidebar } from "vuepress-theme-hope";
var sidebar_default = sidebar(
  {
    "/posts/": "structure"
  }
);

// src/.vuepress/theme.ts
var theme_default = hopeTheme({
  //hostname: "https://20261-ifba-saj-ads-poo.github.io/blog",
  author: {
    name: "Leandro Souza",
    url: "https://github.com/leandro-costa"
  },
  logo: "/logo.svg",
  repo: "20261-ifba-saj-ads-poo/blog",
  docsDir: "src",
  // navbar
  navbar: navbar_default,
  // sidebar
  sidebar: sidebar_default,
  footer: "Material de aula IFBA SAJ",
  displayFooter: true,
  blog: {
    description: "Professor EBTT",
    //intro: "/intro.html",
    //avatar: "/assets/images/ifbasaj.jpg",
    medias: {
      Email: "mailto:leandro.costa@ifba.edu.br",
      GitHub: "https://github.com/leandro-costa"
    }
  },
  metaLocales: {
    editLink: "Edite esta p\xE1gina no GitHub",
    toc: "Nesta P\xE1gina"
  },
  // enable it to preview all changes in time
  hotReload: true,
  // These features are enabled for demo, only preserve features you need here
  markdown: {
    align: true,
    attrs: true,
    codeTabs: true,
    component: true,
    demo: true,
    figure: true,
    gfm: true,
    imgLazyload: true,
    imgSize: true,
    include: true,
    mark: true,
    plantuml: true,
    spoiler: true,
    stylize: [
      {
        matcher: "Recommended",
        replacer: ({ tag }) => {
          if (tag === "em") {
            return {
              tag: "Badge",
              attrs: { type: "tip" },
              content: "Recommended"
            };
          }
        }
      }
    ],
    sub: true,
    sup: true,
    tabs: true,
    tasklist: true,
    vPre: true,
    // uncomment these if you need TeX support
    math: {
      // install katex before enabling it
      //type: "katex",
      // or install @mathjax/src before enabling it
      type: "mathjax"
    }
    // install chart.js before enabling it
    // chartjs: true,
    // install echarts before enabling it
    // echarts: true,
    // install flowchart.ts before enabling it
    // flowchart: true,
    // install mermaid before enabling it
    // mermaid: true,
    // playground: {
    //   presets: ["ts", "vue"],
    // },
    // install @vue/repl before enabling it
    // vuePlayground: true,
    // install sandpack-vue3 before enabling it
    // sandpack: true,
    // install @vuepress/plugin-revealjs and uncomment these if you need slides
    // revealjs: {
    //   plugins: ["highlight", "math", "search", "notes", "zoom"],
    // },
  },
  plugins: {
    blog: {
      excerpt: false
    },
    search: true,
    //slimsearch : true,
    // Install @waline/client before enabling it
    // Note: This is for testing ONLY!
    // You MUST generate and use your own comment service in production.
    // comment: {
    //   provider: "Waline",
    //   serverURL: "https://waline-comment.vuejs.press",
    // },
    components: {
      components: ["Badge", "VPCard"]
    },
    icon: {
      prefix: "fa6-solid:"
    },
    // install @vuepress/plugin-pwa and uncomment these if you want a PWA
    pwa: {
      favicon: "/favicon.ico",
      cacheHTML: true,
      cacheImage: true,
      appendBase: true,
      apple: {
        icon: "/assets/icon/icon-152.png",
        statusBarColor: "black"
      },
      msTile: {
        image: "/assets/icon/icon-144.png",
        color: "#ffffff"
      },
      manifest: {
        icons: [
          {
            src: "/assets/icon/icon-512.png",
            sizes: "512x512",
            purpose: "maskable",
            type: "image/png"
          },
          {
            src: "/assets/icon/icon-192.png",
            sizes: "192x192",
            purpose: "maskable",
            type: "image/png"
          },
          {
            src: "/assets/icon/icon-512.png",
            sizes: "512x512",
            type: "image/png"
          },
          {
            src: "/assets/icon/icon-192.png",
            sizes: "192x192",
            type: "image/png"
          }
        ]
      }
    }
  }
});

// src/.vuepress/config.ts
var config_default = defineUserConfig({
  base: "/blog/",
  lang: "pt-BR",
  title: "2026.1 ADS POO",
  description: "Material das Aulas",
  extendsMarkdown: (md) => {
    md.use(umlPlugin, {
      openMarker: "```plantuml",
      closeMarker: "```"
      //server: 'https://kroki.io/plantuml/'
    });
    md.use(table_captions);
    md.use(container, "figure", {
      render: (tokens, idx) => {
        const m = tokens[idx].info.trim().match(/^figure\s*(.*)$/);
        if (tokens[idx].nesting === 1) {
          return "<figure>\n";
        } else {
          const openToken = tokens.slice(0, idx).reverse().find((t) => t.type === "container_figure_open");
          const captionText = openToken.info.trim().match(/^figure\s*(.*)$/)?.[1];
          const figcaption = captionText ? `<figcaption>${md.utils.escapeHtml(captionText)}</figcaption>` : "";
          return `${figcaption}
</figure>
`;
        }
      }
    });
  },
  theme: theme_default,
  // Enable it with pwa
  shouldPrefetch: true
});
export {
  config_default as default
};
//# sourceMappingURL=data:application/json;base64,ewogICJ2ZXJzaW9uIjogMywKICAic291cmNlcyI6IFsic3JjLy52dWVwcmVzcy9jb25maWcudHMiLCAic3JjLy52dWVwcmVzcy90aGVtZS50cyIsICJzcmMvLnZ1ZXByZXNzL25hdmJhci50cyIsICJzcmMvLnZ1ZXByZXNzL3NpZGViYXIudHMiXSwKICAic291cmNlc0NvbnRlbnQiOiBbImNvbnN0IF9fdml0ZV9pbmplY3RlZF9vcmlnaW5hbF9kaXJuYW1lID0gXCJDOi9Vc2Vycy9MZWFuZHJvL0RvY3VtZW50cy8yMDI2MS9ibG9nL3NyYy8udnVlcHJlc3NcIjtjb25zdCBfX3ZpdGVfaW5qZWN0ZWRfb3JpZ2luYWxfZmlsZW5hbWUgPSBcIkM6XFxcXFVzZXJzXFxcXExlYW5kcm9cXFxcRG9jdW1lbnRzXFxcXDIwMjYxXFxcXGJsb2dcXFxcc3JjXFxcXC52dWVwcmVzc1xcXFxjb25maWcudHNcIjtjb25zdCBfX3ZpdGVfaW5qZWN0ZWRfb3JpZ2luYWxfaW1wb3J0X21ldGFfdXJsID0gXCJmaWxlOi8vL0M6L1VzZXJzL0xlYW5kcm8vRG9jdW1lbnRzLzIwMjYxL2Jsb2cvc3JjLy52dWVwcmVzcy9jb25maWcudHNcIjtpbXBvcnQgeyBkZWZpbmVVc2VyQ29uZmlnIH0gZnJvbSBcInZ1ZXByZXNzXCI7XHJcbmltcG9ydCB1bWxQbHVnaW4gZnJvbSAnbWFya2Rvd24taXQtcGxhbnR1bWwnO1xyXG5pbXBvcnQgY29udGFpbmVyIGZyb20gJ21hcmtkb3duLWl0LWNvbnRhaW5lcic7XHJcbmltcG9ydCB0YWJsZV9jYXB0aW9ucyBmcm9tICdtYXJrZG93bi1pdC10YWJsZS1jYXB0aW9ucydcclxuaW1wb3J0IHRoZW1lIGZyb20gXCIuL3RoZW1lLmpzXCI7XHJcblxyXG5leHBvcnQgZGVmYXVsdCBkZWZpbmVVc2VyQ29uZmlnKHtcclxuICBiYXNlOiBcIi9ibG9nL1wiLFxyXG5cclxuICBsYW5nOiBcInB0LUJSXCIsXHJcbiAgdGl0bGU6IFwiMjAyNi4xIEFEUyBQT09cIixcclxuICBkZXNjcmlwdGlvbjogXCJNYXRlcmlhbCBkYXMgQXVsYXNcIixcclxuXHJcbiAgZXh0ZW5kc01hcmtkb3duOiAobWQpID0+IHtcclxuICAgIG1kLnVzZSh1bWxQbHVnaW4sIHtcclxuICAgICAgb3Blbk1hcmtlcjogJ2BgYHBsYW50dW1sJyxcclxuICAgICAgY2xvc2VNYXJrZXI6ICdgYGAnLFxyXG4gICAgICAvL3NlcnZlcjogJ2h0dHBzOi8va3Jva2kuaW8vcGxhbnR1bWwvJ1xyXG4gICAgfSlcclxuICAgIG1kLnVzZSh0YWJsZV9jYXB0aW9ucylcclxuICAgIG1kLnVzZShjb250YWluZXIsICdmaWd1cmUnLCB7XHJcbiAgICAgIHJlbmRlcjogKHRva2VucywgaWR4KSA9PiB7XHJcbiAgICAgICAgLy8gUHJvY3VyYSBvIHRleHRvIGRhIGxlZ2VuZGEgKGV4OiA6OjogZmlndXJlIE1pbmhhIExlZ2VuZGEpXHJcbiAgICAgICAgY29uc3QgbSA9IHRva2Vuc1tpZHhdLmluZm8udHJpbSgpLm1hdGNoKC9eZmlndXJlXFxzKiguKikkLyk7XHJcblxyXG4gICAgICAgIGlmICh0b2tlbnNbaWR4XS5uZXN0aW5nID09PSAxKSB7XHJcbiAgICAgICAgICAvLyBBYnJlIGFwZW5hcyBvIDxmaWd1cmU+IG5hIHBhcnRlIGRlIGNpbWFcclxuICAgICAgICAgIHJldHVybiAnPGZpZ3VyZT5cXG4nO1xyXG4gICAgICAgIH0gZWxzZSB7XHJcbiAgICAgICAgICAvLyBObyBmZWNobyAobmVzdGluZyA9PT0gLTEpLCByZWN1cGVyYW1vcyBvIHRleHRvIGUgZmVjaGFtb3MgYSB0YWdcclxuICAgICAgICAgIC8vIE5vdGE6IFByZWNpc2Ftb3MgZGUgYWNlZGVyIGFvIHRva2VuIGRlIGFiZXJ0dXJhIHBhcmEgbGVyIG8gdGV4dG8gb3JpZ2luYWxcclxuICAgICAgICAgIGNvbnN0IG9wZW5Ub2tlbiA9IHRva2Vucy5zbGljZSgwLCBpZHgpLnJldmVyc2UoKS5maW5kKHQgPT4gdC50eXBlID09PSAnY29udGFpbmVyX2ZpZ3VyZV9vcGVuJyk7XHJcbiAgICAgICAgICBjb25zdCBjYXB0aW9uVGV4dCA9IG9wZW5Ub2tlbi5pbmZvLnRyaW0oKS5tYXRjaCgvXmZpZ3VyZVxccyooLiopJC8pPy5bMV07XHJcblxyXG4gICAgICAgICAgY29uc3QgZmlnY2FwdGlvbiA9IGNhcHRpb25UZXh0XHJcbiAgICAgICAgICAgID8gYDxmaWdjYXB0aW9uPiR7bWQudXRpbHMuZXNjYXBlSHRtbChjYXB0aW9uVGV4dCl9PC9maWdjYXB0aW9uPmBcclxuICAgICAgICAgICAgOiAnJztcclxuXHJcbiAgICAgICAgICByZXR1cm4gYCR7ZmlnY2FwdGlvbn1cXG48L2ZpZ3VyZT5cXG5gO1xyXG4gICAgICAgIH1cclxuICAgICAgfVxyXG4gICAgfSlcclxuICB9LFxyXG5cclxuICB0aGVtZSxcclxuXHJcbiAgLy8gRW5hYmxlIGl0IHdpdGggcHdhXHJcbiAgc2hvdWxkUHJlZmV0Y2g6IHRydWUsXHJcbn0pO1xyXG4iLCAiY29uc3QgX192aXRlX2luamVjdGVkX29yaWdpbmFsX2Rpcm5hbWUgPSBcIkM6L1VzZXJzL0xlYW5kcm8vRG9jdW1lbnRzLzIwMjYxL2Jsb2cvc3JjLy52dWVwcmVzc1wiO2NvbnN0IF9fdml0ZV9pbmplY3RlZF9vcmlnaW5hbF9maWxlbmFtZSA9IFwiQzpcXFxcVXNlcnNcXFxcTGVhbmRyb1xcXFxEb2N1bWVudHNcXFxcMjAyNjFcXFxcYmxvZ1xcXFxzcmNcXFxcLnZ1ZXByZXNzXFxcXHRoZW1lLnRzXCI7Y29uc3QgX192aXRlX2luamVjdGVkX29yaWdpbmFsX2ltcG9ydF9tZXRhX3VybCA9IFwiZmlsZTovLy9DOi9Vc2Vycy9MZWFuZHJvL0RvY3VtZW50cy8yMDI2MS9ibG9nL3NyYy8udnVlcHJlc3MvdGhlbWUudHNcIjtpbXBvcnQgeyBob3BlVGhlbWUgfSBmcm9tIFwidnVlcHJlc3MtdGhlbWUtaG9wZVwiO1xyXG5cclxuaW1wb3J0IG5hdmJhciBmcm9tIFwiLi9uYXZiYXIuanNcIjtcclxuaW1wb3J0IHNpZGViYXIgZnJvbSBcIi4vc2lkZWJhci5qc1wiO1xyXG5cclxuZXhwb3J0IGRlZmF1bHQgaG9wZVRoZW1lKHtcclxuICAvL2hvc3RuYW1lOiBcImh0dHBzOi8vMjAyNjEtaWZiYS1zYWotYWRzLXBvby5naXRodWIuaW8vYmxvZ1wiLFxyXG5cclxuICBhdXRob3I6IHtcclxuICAgIG5hbWU6IFwiTGVhbmRybyBTb3V6YVwiLFxyXG4gICAgdXJsOiBcImh0dHBzOi8vZ2l0aHViLmNvbS9sZWFuZHJvLWNvc3RhXCIsXHJcbiAgfSxcclxuXHJcbiAgbG9nbzogXCIvbG9nby5zdmdcIixcclxuXHJcbiAgcmVwbzogXCIyMDI2MS1pZmJhLXNhai1hZHMtcG9vL2Jsb2dcIixcclxuXHJcbiAgZG9jc0RpcjogXCJzcmNcIixcclxuXHJcbiAgLy8gbmF2YmFyXHJcbiAgbmF2YmFyLFxyXG5cclxuICAvLyBzaWRlYmFyXHJcbiAgc2lkZWJhcixcclxuXHJcbiAgZm9vdGVyOiBcIk1hdGVyaWFsIGRlIGF1bGEgSUZCQSBTQUpcIixcclxuXHJcbiAgZGlzcGxheUZvb3RlcjogdHJ1ZSxcclxuXHJcbiAgYmxvZzoge1xyXG4gICAgZGVzY3JpcHRpb246IFwiUHJvZmVzc29yIEVCVFRcIixcclxuICAgIC8vaW50cm86IFwiL2ludHJvLmh0bWxcIixcclxuICAgIC8vYXZhdGFyOiBcIi9hc3NldHMvaW1hZ2VzL2lmYmFzYWouanBnXCIsXHJcbiAgICBtZWRpYXM6IHtcclxuICAgICAgRW1haWw6IFwibWFpbHRvOmxlYW5kcm8uY29zdGFAaWZiYS5lZHUuYnJcIixcclxuICAgICAgR2l0SHViOiBcImh0dHBzOi8vZ2l0aHViLmNvbS9sZWFuZHJvLWNvc3RhXCIsXHJcbiAgICB9LFxyXG5cclxuICB9LFxyXG5cclxuICBtZXRhTG9jYWxlczoge1xyXG4gICAgZWRpdExpbms6IFwiRWRpdGUgZXN0YSBwXHUwMEUxZ2luYSBubyBHaXRIdWJcIixcclxuICAgIHRvYzogXCJOZXN0YSBQXHUwMEUxZ2luYVwiLFxyXG4gIH0sXHJcblxyXG4gIC8vIGVuYWJsZSBpdCB0byBwcmV2aWV3IGFsbCBjaGFuZ2VzIGluIHRpbWVcclxuICBob3RSZWxvYWQ6IHRydWUsXHJcblxyXG4gIC8vIFRoZXNlIGZlYXR1cmVzIGFyZSBlbmFibGVkIGZvciBkZW1vLCBvbmx5IHByZXNlcnZlIGZlYXR1cmVzIHlvdSBuZWVkIGhlcmVcclxuICBtYXJrZG93bjoge1xyXG4gICAgYWxpZ246IHRydWUsXHJcbiAgICBhdHRyczogdHJ1ZSxcclxuICAgIGNvZGVUYWJzOiB0cnVlLFxyXG4gICAgY29tcG9uZW50OiB0cnVlLFxyXG4gICAgZGVtbzogdHJ1ZSxcclxuICAgIGZpZ3VyZTogdHJ1ZSxcclxuICAgIGdmbTogdHJ1ZSxcclxuICAgIGltZ0xhenlsb2FkOiB0cnVlLFxyXG4gICAgaW1nU2l6ZTogdHJ1ZSxcclxuICAgIGluY2x1ZGU6IHRydWUsXHJcbiAgICBtYXJrOiB0cnVlLFxyXG4gICAgcGxhbnR1bWw6IHRydWUsXHJcbiAgICBzcG9pbGVyOiB0cnVlLFxyXG4gICAgc3R5bGl6ZTogW1xyXG4gICAgICB7XHJcbiAgICAgICAgbWF0Y2hlcjogXCJSZWNvbW1lbmRlZFwiLFxyXG4gICAgICAgIHJlcGxhY2VyOiAoeyB0YWcgfSkgPT4ge1xyXG4gICAgICAgICAgaWYgKHRhZyA9PT0gXCJlbVwiKSB7XHJcbiAgICAgICAgICAgIHJldHVybiB7XHJcbiAgICAgICAgICAgICAgdGFnOiBcIkJhZGdlXCIsXHJcbiAgICAgICAgICAgICAgYXR0cnM6IHsgdHlwZTogXCJ0aXBcIiB9LFxyXG4gICAgICAgICAgICAgIGNvbnRlbnQ6IFwiUmVjb21tZW5kZWRcIixcclxuICAgICAgICAgICAgfTtcclxuICAgICAgICAgIH1cclxuICAgICAgICB9LFxyXG4gICAgICB9LFxyXG4gICAgXSxcclxuICAgIHN1YjogdHJ1ZSxcclxuICAgIHN1cDogdHJ1ZSxcclxuICAgIHRhYnM6IHRydWUsXHJcbiAgICB0YXNrbGlzdDogdHJ1ZSxcclxuICAgIHZQcmU6IHRydWUsXHJcblxyXG4gICAgLy8gdW5jb21tZW50IHRoZXNlIGlmIHlvdSBuZWVkIFRlWCBzdXBwb3J0XHJcbiAgICAgbWF0aDoge1xyXG4gICAgICAgLy8gaW5zdGFsbCBrYXRleCBiZWZvcmUgZW5hYmxpbmcgaXRcclxuICAgICAgIC8vdHlwZTogXCJrYXRleFwiLFxyXG4gICAgICAgLy8gb3IgaW5zdGFsbCBAbWF0aGpheC9zcmMgYmVmb3JlIGVuYWJsaW5nIGl0XHJcbiAgICAgICB0eXBlOiBcIm1hdGhqYXhcIixcclxuICAgICB9LFxyXG5cclxuICAgIC8vIGluc3RhbGwgY2hhcnQuanMgYmVmb3JlIGVuYWJsaW5nIGl0XHJcbiAgICAvLyBjaGFydGpzOiB0cnVlLFxyXG5cclxuICAgIC8vIGluc3RhbGwgZWNoYXJ0cyBiZWZvcmUgZW5hYmxpbmcgaXRcclxuICAgIC8vIGVjaGFydHM6IHRydWUsXHJcblxyXG4gICAgLy8gaW5zdGFsbCBmbG93Y2hhcnQudHMgYmVmb3JlIGVuYWJsaW5nIGl0XHJcbiAgICAvLyBmbG93Y2hhcnQ6IHRydWUsXHJcblxyXG4gICAgLy8gaW5zdGFsbCBtZXJtYWlkIGJlZm9yZSBlbmFibGluZyBpdFxyXG4gICAgLy8gbWVybWFpZDogdHJ1ZSxcclxuXHJcbiAgICAvLyBwbGF5Z3JvdW5kOiB7XHJcbiAgICAvLyAgIHByZXNldHM6IFtcInRzXCIsIFwidnVlXCJdLFxyXG4gICAgLy8gfSxcclxuXHJcbiAgICAvLyBpbnN0YWxsIEB2dWUvcmVwbCBiZWZvcmUgZW5hYmxpbmcgaXRcclxuICAgIC8vIHZ1ZVBsYXlncm91bmQ6IHRydWUsXHJcblxyXG4gICAgLy8gaW5zdGFsbCBzYW5kcGFjay12dWUzIGJlZm9yZSBlbmFibGluZyBpdFxyXG4gICAgLy8gc2FuZHBhY2s6IHRydWUsXHJcblxyXG4gICAgLy8gaW5zdGFsbCBAdnVlcHJlc3MvcGx1Z2luLXJldmVhbGpzIGFuZCB1bmNvbW1lbnQgdGhlc2UgaWYgeW91IG5lZWQgc2xpZGVzXHJcbiAgICAvLyByZXZlYWxqczoge1xyXG4gICAgLy8gICBwbHVnaW5zOiBbXCJoaWdobGlnaHRcIiwgXCJtYXRoXCIsIFwic2VhcmNoXCIsIFwibm90ZXNcIiwgXCJ6b29tXCJdLFxyXG4gICAgLy8gfSxcclxuICB9LFxyXG5cclxuICBwbHVnaW5zOiB7XHJcbiAgICBibG9nOiB7XHJcbiAgICAgIGV4Y2VycHQ6IGZhbHNlXHJcbiAgICB9LFxyXG4gICAgc2VhcmNoIDogdHJ1ZSxcclxuICAgIC8vc2xpbXNlYXJjaCA6IHRydWUsXHJcblxyXG4gICAgLy8gSW5zdGFsbCBAd2FsaW5lL2NsaWVudCBiZWZvcmUgZW5hYmxpbmcgaXRcclxuICAgIC8vIE5vdGU6IFRoaXMgaXMgZm9yIHRlc3RpbmcgT05MWSFcclxuICAgIC8vIFlvdSBNVVNUIGdlbmVyYXRlIGFuZCB1c2UgeW91ciBvd24gY29tbWVudCBzZXJ2aWNlIGluIHByb2R1Y3Rpb24uXHJcbiAgICAvLyBjb21tZW50OiB7XHJcbiAgICAvLyAgIHByb3ZpZGVyOiBcIldhbGluZVwiLFxyXG4gICAgLy8gICBzZXJ2ZXJVUkw6IFwiaHR0cHM6Ly93YWxpbmUtY29tbWVudC52dWVqcy5wcmVzc1wiLFxyXG4gICAgLy8gfSxcclxuXHJcbiAgICBjb21wb25lbnRzOiB7XHJcbiAgICAgIGNvbXBvbmVudHM6IFtcIkJhZGdlXCIsIFwiVlBDYXJkXCJdLFxyXG4gICAgfSxcclxuXHJcbiAgICBpY29uOiB7XHJcbiAgICAgIHByZWZpeDogXCJmYTYtc29saWQ6XCIsXHJcbiAgICB9LFxyXG5cclxuICAgIC8vIGluc3RhbGwgQHZ1ZXByZXNzL3BsdWdpbi1wd2EgYW5kIHVuY29tbWVudCB0aGVzZSBpZiB5b3Ugd2FudCBhIFBXQVxyXG4gICAgcHdhOiB7XHJcbiAgICAgIGZhdmljb246IFwiL2Zhdmljb24uaWNvXCIsXHJcbiAgICAgIGNhY2hlSFRNTDogdHJ1ZSxcclxuICAgICAgY2FjaGVJbWFnZTogdHJ1ZSxcclxuICAgICAgYXBwZW5kQmFzZTogdHJ1ZSxcclxuICAgICAgYXBwbGU6IHtcclxuICAgICAgICBpY29uOiBcIi9hc3NldHMvaWNvbi9pY29uLTE1Mi5wbmdcIixcclxuICAgICAgICBzdGF0dXNCYXJDb2xvcjogXCJibGFja1wiLFxyXG4gICAgICB9LFxyXG4gICAgICBtc1RpbGU6IHtcclxuICAgICAgICBpbWFnZTogXCIvYXNzZXRzL2ljb24vaWNvbi0xNDQucG5nXCIsXHJcbiAgICAgICAgY29sb3I6IFwiI2ZmZmZmZlwiLFxyXG4gICAgICB9LFxyXG4gICAgICBtYW5pZmVzdDoge1xyXG4gICAgICAgIGljb25zOiBbXHJcbiAgICAgICAgICB7XHJcbiAgICAgICAgICAgIHNyYzogXCIvYXNzZXRzL2ljb24vaWNvbi01MTIucG5nXCIsXHJcbiAgICAgICAgICAgIHNpemVzOiBcIjUxMng1MTJcIixcclxuICAgICAgICAgICAgcHVycG9zZTogXCJtYXNrYWJsZVwiLFxyXG4gICAgICAgICAgICB0eXBlOiBcImltYWdlL3BuZ1wiLFxyXG4gICAgICAgICAgfSxcclxuICAgICAgICAgIHtcclxuICAgICAgICAgICAgc3JjOiBcIi9hc3NldHMvaWNvbi9pY29uLTE5Mi5wbmdcIixcclxuICAgICAgICAgICAgc2l6ZXM6IFwiMTkyeDE5MlwiLFxyXG4gICAgICAgICAgICBwdXJwb3NlOiBcIm1hc2thYmxlXCIsXHJcbiAgICAgICAgICAgIHR5cGU6IFwiaW1hZ2UvcG5nXCIsXHJcbiAgICAgICAgICB9LFxyXG4gICAgICAgICAge1xyXG4gICAgICAgICAgICBzcmM6IFwiL2Fzc2V0cy9pY29uL2ljb24tNTEyLnBuZ1wiLFxyXG4gICAgICAgICAgICBzaXplczogXCI1MTJ4NTEyXCIsXHJcbiAgICAgICAgICAgIHR5cGU6IFwiaW1hZ2UvcG5nXCIsXHJcbiAgICAgICAgICB9LFxyXG4gICAgICAgICAge1xyXG4gICAgICAgICAgICBzcmM6IFwiL2Fzc2V0cy9pY29uL2ljb24tMTkyLnBuZ1wiLFxyXG4gICAgICAgICAgICBzaXplczogXCIxOTJ4MTkyXCIsXHJcbiAgICAgICAgICAgIHR5cGU6IFwiaW1hZ2UvcG5nXCIsXHJcbiAgICAgICAgICB9LFxyXG4gICAgICAgIF0sXHJcbiAgICAgIH0sXHJcbiAgICB9LFxyXG4gIH0sXHJcbn0pO1xyXG4iLCAiY29uc3QgX192aXRlX2luamVjdGVkX29yaWdpbmFsX2Rpcm5hbWUgPSBcIkM6L1VzZXJzL0xlYW5kcm8vRG9jdW1lbnRzLzIwMjYxL2Jsb2cvc3JjLy52dWVwcmVzc1wiO2NvbnN0IF9fdml0ZV9pbmplY3RlZF9vcmlnaW5hbF9maWxlbmFtZSA9IFwiQzpcXFxcVXNlcnNcXFxcTGVhbmRyb1xcXFxEb2N1bWVudHNcXFxcMjAyNjFcXFxcYmxvZ1xcXFxzcmNcXFxcLnZ1ZXByZXNzXFxcXG5hdmJhci50c1wiO2NvbnN0IF9fdml0ZV9pbmplY3RlZF9vcmlnaW5hbF9pbXBvcnRfbWV0YV91cmwgPSBcImZpbGU6Ly8vQzovVXNlcnMvTGVhbmRyby9Eb2N1bWVudHMvMjAyNjEvYmxvZy9zcmMvLnZ1ZXByZXNzL25hdmJhci50c1wiO2ltcG9ydCB7IG5hdmJhciB9IGZyb20gXCJ2dWVwcmVzcy10aGVtZS1ob3BlXCI7XHJcblxyXG5leHBvcnQgZGVmYXVsdCBuYXZiYXIoW1xyXG4gIFwiL1wiLFxyXG4gIHtcclxuICAgIHRleHQ6IFwiQXVsYXNcIixcclxuICAgIGljb246IFwiZWRpdFwiLFxyXG4gICAgbGluazogXCIvY2F0ZWdvcnkvYXVsYS9cIixcclxuICB9LFxyXG4gIHtcclxuICAgIHRleHQ6IFwiRXhlcmNcdTAwRURjaW9zXCIsXHJcbiAgICBpY29uOiBcImR1bWJiZWxsXCIsXHJcbiAgICBsaW5rOiBcIi9jYXRlZ29yeS9leGVyY2ljaW8vXCIsXHJcbiAgfSxcclxuICB7XHJcbiAgICB0ZXh0OiBcIlRyYWJhbGhvXCIsXHJcbiAgICBpY29uOiBcImNvZGUtcHVsbC1yZXF1ZXN0XCIsXHJcbiAgICBsaW5rOiBcIi9jYXRlZ29yeS90cmFiYWxoby9cIixcclxuICB9LFxyXG4gIHtcclxuICAgIHRleHQ6IFwiUGFyYSBFbnRyZWdhXCIsXHJcbiAgICBpY29uOiBcInBhcGVyLXBsYW5lXCIsXHJcbiAgICBsaW5rOiBcIi9jYXRlZ29yeS9lbnRyZWdhL1wiLFxyXG4gIH0sXHJcbiAge1xyXG4gICAgdGV4dDogXCJDYXRlZ29yaWFcIixcclxuICAgIGljb246IFwibGlzdFwiLFxyXG4gICAgbGluazogXCIvY2F0ZWdvcnkvXCIsXHJcbiAgfSxcclxuICB7XHJcbiAgICB0ZXh0OiBcIlRhZ1wiLFxyXG4gICAgaWNvbjogXCJ0YWdcIixcclxuICAgIGxpbms6IFwiL3RhZy9cIixcclxuICB9LFxyXG4gIHtcclxuICAgIHRleHQ6IFwiVGltZWxpbmVcIixcclxuICAgIGljb246IFwiY2xvY2tcIixcclxuICAgIGxpbms6IFwiL3RpbWVsaW5lL1wiLFxyXG4gIH0sXHJcbiAge1xyXG4gICAgdGV4dDogXCJJbXByaW1pclwiLFxyXG4gICAgaWNvbjogXCJwcmludFwiLFxyXG4gICAgbGluazogXCIvcG9zdHMvcHJpbnQubWRcIlxyXG4gIH1cclxuXSk7XHJcbiIsICJjb25zdCBfX3ZpdGVfaW5qZWN0ZWRfb3JpZ2luYWxfZGlybmFtZSA9IFwiQzovVXNlcnMvTGVhbmRyby9Eb2N1bWVudHMvMjAyNjEvYmxvZy9zcmMvLnZ1ZXByZXNzXCI7Y29uc3QgX192aXRlX2luamVjdGVkX29yaWdpbmFsX2ZpbGVuYW1lID0gXCJDOlxcXFxVc2Vyc1xcXFxMZWFuZHJvXFxcXERvY3VtZW50c1xcXFwyMDI2MVxcXFxibG9nXFxcXHNyY1xcXFwudnVlcHJlc3NcXFxcc2lkZWJhci50c1wiO2NvbnN0IF9fdml0ZV9pbmplY3RlZF9vcmlnaW5hbF9pbXBvcnRfbWV0YV91cmwgPSBcImZpbGU6Ly8vQzovVXNlcnMvTGVhbmRyby9Eb2N1bWVudHMvMjAyNjEvYmxvZy9zcmMvLnZ1ZXByZXNzL3NpZGViYXIudHNcIjtpbXBvcnQgeyBzaWRlYmFyIH0gZnJvbSBcInZ1ZXByZXNzLXRoZW1lLWhvcGVcIjtcclxuXHJcbmV4cG9ydCBkZWZhdWx0IHNpZGViYXIoe1xyXG4gICAgXCIvcG9zdHMvXCI6IFwic3RydWN0dXJlXCIs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
