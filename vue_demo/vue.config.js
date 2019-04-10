// https://cli.vuejs.org/zh/config/#publicpath 官网
const path = require('path')
const debug = process.env.NODE_ENV !== 'production'

module.exports = {
  // 基本路径
  // 如果有子路径这里要加上
  baseUrl: '/',

  // 输出文件目录 当运行 vue-cli-service build 时生成的生产环境构建文件的目录
  // dist'为默认目标目录，目标目录构建之前会被清楚（构建时 传入--no-clean）
  outputDir: 'dist',
  // 放置静态资源目录 (js, css, img, fonts)
  assetsDir: 'assets',
  // eslint-loader 是否在保存的时候检查代码规范
  // 当设置为 `"error"` 时，检查出的错误会触发编译失败。lint 错误在开发时直接显示在浏览器
  lintOnSave: true,
  // 是否使用包含运行时编译器的 Vue 构建版本。设置为 true 后你就可以在 Vue 组件中使用 template 选项了
  runtimeCompiler: true,
  // webpack配置
  // see https://github.com/vuejs/vue-cli/blob/dev/docs/webpack.md   webpack链接API，用于生成和修改webapck配置
  chainWebpack: () => {
    if (debug) {
      // 本地开发配置
    } else {
      // 生产开发配置
    }
  },
  // webpack配置，值为对象时会合并到配置中，为方法时会改写配置
  configureWebpack: (config) => {
    if (debug) { // 开发环境配置
      config.devtool = 'cheap-module-eval-source-map'
    } else { // 生产环境配置

    }
    Object.assign(config, { // 开发生产共同配置
      resolve: {
        alias: {
          '@': path.resolve(__dirname, './src')// 设置路径别名
        }
      }
    })
  },
  // vue-loader 配置项
  // https://vue-loader.vuejs.org/en/options.html
  // vueLoader: {},

  // 生产环境是否生成 sourceMap 文件
  productionSourceMap: false,
  // css相关配置 配置高于chainWebpack中关于css loader的配置
  css: {
    // 是否使用css分离插件 ExtractTextPlugin 将组件中的 CSS 提取至一个独立的 CSS 文件中
    extract: false,
    // 开启 CSS source maps?是否在构建样式地图，false将提高构建速度
    sourceMap: false,
    // css预设器配置项
    loaderOptions: {
      less: {
        // 传递给less-loader
      }
    },
    // 为所有的 CSS 及其预处理文件开启 CSS Modules
    // 默认情况下，只有 *.module.[ext] 结尾的文件才会被视作 CSS Modules 模块。设置为 true 后你就可以去掉文件名中的 .module 并将所有的 *.(css|scss|sass|less|styl(us)?) 文件视为 CSS Modules 模块。
    modules: false
  },
  // 是否为 Babel 或 TypeScript 使用 thread-loader,构建时开启多进程处理babel编译
  parallel: require('os').cpus().length > 1,
  // PWA 插件相关配置
  // see https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-pwa
  pwa: {},
  // webpack-dev-server 相关配置
  devServer: {
    open: process.platform === 'darwin',
    host: 'localhost',
    port: 8088,
    https: false,
    hotOnly: false,
    // 如果你的前端应用和后端 API 服务器没有运行在同一个主机上，你需要在开发环境下将 API 请求代理到 API 服务器。
    // 查阅 https://github.com/vuejs/vue-doc-zh-cn/vue-cli/cli-service.md#配置代理
    proxy: null, // 设置代理
    before: app => {}
  },
  // 第三方插件配置
  pluginOptions: {
    // ...
  }
}
