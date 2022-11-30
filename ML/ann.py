import pandas as pd
from sklearn.neural_network import MLPClassifier

data = pd.read_csv('C:\Users\User\Desktop\Algorithm\ML\data.csv', sep=',')
print(data)

target = 'y'
X = data.drop(target, axis=1)
y = data.loc[:, target].values

clf = MLPClassifier(max_iter=300).fit(X, y)
# clf2 = MLPClassifier(hidden_layer_sizes=(2,), learning_rate_init=0.1, max_iter=1000)
# clf2.fit(X, y)


pred_clf = clf.predict_proba(X)
print(pred_clf)
# clf2.predict(X)

