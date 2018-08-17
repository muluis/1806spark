var express = require('express');
var app = express();

let port = 3000;
app.listen(port, ()=> console.log('Todo client on port'));

app.get('', function(req, resp, next){
    console.log('someone is requesting the base/template html page')
    resp.sendfile('C:\\Revature\\git_repos\\1806spark\\chester_gillfillian_code\\TODO_CLIENT\\template.html')
});

app.use('/pages', express.static('pages'));
app.use('/js', express.static('js'));