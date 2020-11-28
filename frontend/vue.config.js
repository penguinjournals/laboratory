module.exports = {
  devServer: {
    port: 8181,
    proxy: {
      'api': {
        target: 'http://localhost:8080'
      }
    }
  },
  outputDir: 'target/dist',
  assetsDir: 'static'
}
