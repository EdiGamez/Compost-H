import numpy as np
from flask import Flask, request, jsonify
import tensorflow as tf
import pickle
import json
from sklearn.preprocessing import StandardScaler
from flask_cors import CORS

model = tf.keras.models.load_model("../utils/modelo.keras")
with open("../utils/escaladores.pickle", "rb") as f:
    scalers = pickle.load(f)

scaler_entrada = scalers["entrada"]
scaler_salida = scalers["salida"]

app = Flask(__name__)
CORS(app)


@app.route('/api/receive_data', methods=['POST'])
def receive_data():
    print('Received data')
    try:
        data = request.get_json()
        if not data:
            return jsonify({'error': 'No data received'}), 400
        print(data)
       
        features = ['urea', 'pollinaza', 'harinolina', 'yeso', 'nitTeorico', 'totalBs', 'tonPolloBh', 'm3Vuelta1', 'm3Vuelta2', 'm3Vuelta3', 'humedadFinal', 'm3Vuelta4', 'porcHumedadVueltas', 'bhLl1', 'bsLl1', 'humedadLl1', 'bhLl2', 'bsLl2', 'm3TonLl2', 'bhLl3', 'bsLl3']
        missing_features = [feature for feature in features if feature not in data]

        if missing_features:
            return jsonify({'error': f'Missing features in data: {missing_features}'}), 400

        all_data = np.array([[data.get(feature) for feature in features]])
        print(all_data)
        all_data_norm = scaler_entrada.transform(all_data)
        
        entrada1 = all_data_norm[:, :11]
        entrada2 = all_data_norm[:, :18]
        entrada3 = all_data_norm 

        salida1,salida2,salida3 = model.predict([entrada1, entrada2, entrada3])
        predicciones = {
            'salida1': {'value': float(scaler_salida.inverse_transform(salida1)[0][0])},
            'salida2': {'value': float(scaler_salida.inverse_transform(salida2)[0][0])},
            'salida3': {'value': float(scaler_salida.inverse_transform(salida3)[0][0])}
        }

        return jsonify(predicciones), 200
    except Exception as e:
        return jsonify({'error': str(e)}), 500

if __name__ == '__main__':
    app.run(debug=True)