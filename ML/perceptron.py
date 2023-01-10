import numpy as np

def fun_perceptron_1(): 
    X, y =
    W,b=
    nEpx = 100; E_ = 999; E_v = np.zeros(nEpx) 
    lr =0.1;  h = tansig
    for epoch in range(nEpochs): 
        print('Epoch {}:' . format(epoch)) 
        for i in range(X.shape[0]):
            o = h(W.dot(X[i]) + b) 
            e = y[i] – o
            W, b = W + lr*e*X[i], b + lr*e 
        E = rmse( y – predict(X, W, b, h)) 
        dE = (E_ - E) / E_
        E_v[epoch] = E
        if E < 0.01 or dE < 0.01: 
            break
        else: E_ = E
    print('Done W* = {}, b* = {}' . Format(W, b)) 
    print('E_v = ', E_v)
    
def sigmoid(s):
    return 1/(1 + np.exp(-s)) 
def tansig(s):
    return 2*sigmoid(s) - 1 
def rmse(E):
    return np.sqrt(E.dot(E)) 
def predict(X,W,b,h):
    pred = np.zeros(X.shape[0]) 
    for i in range(X.shape[0]):
        pred[i] = h(W.dot(X[i])) 
    return pred

def predict(X,W,b,h):
    pred = np.zeros(X.shape[0]) 
    for i in range(X.shape[0]):
        pred[i] = h(W.dot(X[i]) + b) 
    return pred

fun_perceptron_0() 
fun_perceptron_1()