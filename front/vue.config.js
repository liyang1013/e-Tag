const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
  productionSourceMap: false,
  transpileDependencies: true,
  lintOnSave: false, //忽略lint检测
  //请求代理
  devServer: {
    open: true,
    // host: "localhost",
    port: "80",
    https: false,
    hot: "only", 
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        pathRewrite: {
          '/api': ''
        }
      },
    }
  }
});
