function namespace(n, t) {
    for (var r = t || this, u = n.split("."), i = 0; i < u.length; i++)
        r[u[i]] === undefined && (r[u[i]] = {}),
        r = r[u[i]]
}