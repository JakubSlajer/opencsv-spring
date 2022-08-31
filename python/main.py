import pandas
from pathlib import Path

source_path: Path = Path(__file__).resolve()
root_dir: Path = source_path.parent.parent

file_path = root_dir / "docs/data.csv"

if file_path.is_file():
    data = pandas.read_csv(file_path)
    print("Reading CSV file %s" % file_path)
    print(data)
    data.to_html("output/shares.html")
    print("Generating HTML file %s" % (source_path.parent / "output/shares.html"))
else:
    print("missing data.csv file!")

