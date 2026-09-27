import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv("results/results.csv")

for algorithm in df["Algorithm"].unique():
    data = df[df["Algorithm"] == algorithm]

    plt.plot(data["Size"], data["Time"], marker="o", label=algorithm)

plt.xlabel("Input size (n)")
plt.ylabel("Execution time (ns)")
plt.title("Time vs n")
plt.legend()
plt.grid()
plt.savefig("docs/plots/time_vs_n.png")
plt.close()

for algorithm in df["Algorithm"].unique():
    data = df[df["Algorithm"] == algorithm]

    plt.plot(data["Size"], data["Depth"], marker="o", label=algorithm)

plt.xlabel("Input size (n)")
plt.ylabel("Recursion depth")
plt.title("Recursion Depth vs n")
plt.legend()
plt.grid()
plt.savefig("docs/plots/depth_vs_n.png")
plt.close()

print("Plots created.")