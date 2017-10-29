namespace('crystalshard.ruby.ui.components');

crystalshard.ruby.ui.components.Path = (function () {

    // Fields
    var path,
        callback,
        regex;

    function Path(path, callback) {
        this.path = path;
        this.callback = callback;
        this.regex = RegExp(path);
    }

    Path.prototype.getPath = function() {
        return this.path;
    };

    Path.prototype.getCallback = function() {
        return this.callback;
    };

    Path.prototype.getRegex = function() {
        return this.regex;
    };

    Path.prototype.checkRegex = function(path) {
        return this.regex.test(path);
    };

    Path.prototype.getMatches = function(path) {
        return path.match(this.regex);
    };

    return Path;

})();